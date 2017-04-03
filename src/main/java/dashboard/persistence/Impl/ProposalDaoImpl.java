package dashboard.persistence.Impl;

import dashboard.dto.Proposal;
import dashboard.persistence.Database;
import dashboard.persistence.ProposalDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 02/04/2017.
 */
public class ProposalDaoImpl implements ProposalDao{


    private Connection con = Database.getConnection();

    @Override
    public List<Proposal> getProposals() {
        List<Proposal> proposals = new ArrayList<Proposal>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement("SELECT * FROM PUBLIC.PROPOSAL");

            rs = pst.executeQuery();
            while (rs.next()) {

                Integer idProp = rs.getInt("id");
                String content = rs.getString("content");
                Integer votes = rs.getInt("votes");
                Integer category_id = rs.getInt("category_id");
                Integer userID = rs.getInt("user_id");

                Proposal proposal = new Proposal(content, votes, category_id, userID);
                proposal.setId(idProp);

                proposals.add(proposal);
            }

            return proposals;

        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
