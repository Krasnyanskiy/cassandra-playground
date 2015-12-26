package il.arri.cassandra.playground.spring.web;

import il.arri.cassandra.playground.spring.NoUserFoundException;
import il.arri.cassandra.playground.spring.domain.User;
import il.arri.cassandra.playground.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Arri Goldberg
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/{firstname}")
    public User getUserBy(@PathVariable String firstname) {
        Optional<User> maybeUser = userService.getUserBy(firstname);
        //
        // Check if user presents
        //
        if (maybeUser.isPresent()) {
            return maybeUser.get();
        }

        throw new NoUserFoundException(firstname);
    }

}
