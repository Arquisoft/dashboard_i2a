package org.arquisoft.kafka.dashboard.services.impl;

import org.arquisoft.kafka.dashboard.repositories.UserRepository;
import org.arquisoft.kafka.dashboard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Daniel on 10-Apr-17.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }
}
