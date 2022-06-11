package utils.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * This interface allows you to store new Users into the Database
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByNameAndPassword(String name, String password);
    User findByName(String name);
}
