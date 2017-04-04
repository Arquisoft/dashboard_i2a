package dashboard.persistence;

import dashboard.dto.Category;

/**
 * Created by Alex on 04/04/2017.
 */
public interface CategoryDao {

    Category getCategoryById(int id);
}
