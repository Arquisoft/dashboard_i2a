package org.arquisoft.kafka.dashboard.services.impl;

import org.arquisoft.kafka.dashboard.model.Category;
import org.arquisoft.kafka.dashboard.repositories.CategoryRepository;
import org.arquisoft.kafka.dashboard.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Daniel on 10-Apr-17. Category service implementation
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(){return (List<Category>) repository.findAll();}
}
