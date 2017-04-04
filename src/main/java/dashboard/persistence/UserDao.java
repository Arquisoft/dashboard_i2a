package dashboard.persistence;

import dashboard.dto.User;

/**
 * Created by Alex on 04/04/2017.
 */
public interface UserDao {

    User getUserById(int id);
}
