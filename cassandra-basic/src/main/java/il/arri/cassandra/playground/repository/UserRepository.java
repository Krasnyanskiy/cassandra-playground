package il.arri.cassandra.playground.repository;

import com.datastax.driver.core.ResultSetFuture;
import il.arri.cassandra.playground.model.User;

/**
 * @author Arri Goldberg
 */
public interface UserRepository {

    ResultSetFuture create(User user);
    ResultSetFuture update(User user);
    User get(String name);

}
