package org.arquisoft.kafka.dashboard.services.impl;

import org.arquisoft.kafka.dashboard.repositories.CommentRepository;
import org.arquisoft.kafka.dashboard.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Daniel on 10-Apr-17.
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    @Autowired
    public CommentServiceImpl(CommentRepository repository) {
        this.repository = repository;
    }
}
