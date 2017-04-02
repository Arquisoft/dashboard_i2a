package dashboard;

import dashboard.model.Proposal;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Alex on 02/04/2017.
 */
public interface ProposalRepository extends CrudRepository<Proposal, Long> {


}
