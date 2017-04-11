package org.arquisoft.kafka.dashboard.repositories;

import org.arquisoft.kafka.dashboard.model.Proposal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Daniel on 10-Apr-17.
 */
@Repository("proposalRepository")
public interface ProposalRepository extends CrudRepository<Proposal,Long> {
}
