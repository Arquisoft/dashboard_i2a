package dashboard.persistence;

import dashboard.dto.Proposal;

import java.util.List;

/**
 * Created by Alex on 02/04/2017.
 */
public interface ProposalDao {

    List<Proposal> getProposals();
}
