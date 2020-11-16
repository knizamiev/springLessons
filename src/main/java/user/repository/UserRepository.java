package user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    //custom qwery

    List<User> findAllByLastName(String name);

    User findFirstByFirstName(String name);


}
