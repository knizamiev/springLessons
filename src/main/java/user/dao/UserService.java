package user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.model.User;
import user.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    //read
    public List<User> readAll(){
        return userRepository.findAll();
    }

    public List<User> findAllByLastName(String lastName){
        return userRepository.findAllByLastName(lastName);
    }

    public User findUserByFitstname(String firsName){
        return userRepository.findFirstByFirstName(firsName);
    }


    //create
    public void saveUser(User user){
        userRepository.save(user);
    }

    //delete
    public void delete(User user){
        User deleteUser = readAll().stream().filter(userKey-> userKey.getFirstName().equals(user.getFirstName())).findFirst().orElse(null);
        userRepository.delete(deleteUser);
    }

    // update

}
