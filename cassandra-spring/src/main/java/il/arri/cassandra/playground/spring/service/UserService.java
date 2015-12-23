package il.arri.cassandra.playground.spring.service;

import il.arri.cassandra.playground.model.User;
import il.arri.cassandra.playground.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Arri Goldberg
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserBy(String firstname) {
        return userRepository.get(firstname);
    }

}
