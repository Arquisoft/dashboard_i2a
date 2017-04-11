package org.arquisoft.kafka.dashboard.services.impl;

import org.arquisoft.kafka.dashboard.repositories.ProposalRepository;
import org.arquisoft.kafka.dashboard.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Daniel on 10-Apr-17.
 */
@Service
public class ProposalServiceImpl implements ProposalService {

    @Qualifier("proposalRepository")
    @Autowired
    private ProposalRepository proposalRepository;


}
