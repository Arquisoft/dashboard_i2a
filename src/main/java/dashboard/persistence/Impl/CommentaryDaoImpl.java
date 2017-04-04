package dashboard.persistence.Impl;

import dashboard.dto.Commentary;
import dashboard.persistence.CommentaryDao;
import dashboard.persistence.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Alex on 02/04/2017.
 * Data Access Object for Commentary table.
 */
public class CommentaryDaoImpl implements CommentaryDao{

    private Connection con = Database.getConnection();

    @Override
    public List<Commentary> getCommentariesFromProposalId(Integer id) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Commentary> comments = new ArrayList<Commentary>();
        try {
            pst = con.prepareStatement("SELECT * FROM PUBLIC.COMMENTARY WHERE PROPOSAL_ID=?");
            pst.setInt(1, id);

            rs = pst.executeQuery();
            while (rs.next()) {

                Integer idComment = rs.getInt("id");
                String content = rs.getString("content");
                Integer votes = rs.getInt("votes");
                Date fecha = rs.getDate("fecha");
                Integer userID = rs.getInt("user_id");
                Integer proposalID = rs.getInt("proposal_id");

                Commentary comment = new Commentary(idComment, content, votes, fecha, userID, proposalID);

                comments.add(comment);
            }
            return comments;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
