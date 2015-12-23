package il.arri.cassandra.playground.spring.web;

import il.arri.cassandra.playground.model.User;
import il.arri.cassandra.playground.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Arri Goldberg
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/{name}")
    public User getUserBy(@PathVariable String name) {
        return userService.getUserBy(name);
    }

}
