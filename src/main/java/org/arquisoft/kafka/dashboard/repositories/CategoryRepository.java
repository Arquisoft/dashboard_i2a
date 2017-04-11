package org.arquisoft.kafka.dashboard.repositories;

import org.arquisoft.kafka.dashboard.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Daniel on 10-Apr-17.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
