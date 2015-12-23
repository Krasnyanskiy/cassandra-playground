package il.arri.cassandra.playground.spring.service;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import il.arri.cassandra.playground.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

/**
 * @author Arri Goldberg
 */
@Service
public class UserService {

    @Autowired
    private CassandraTemplate cassandraTemplate;

    public Optional<User> getUserBy(String firstname) {
        Select query = QueryBuilder.select()
                .from("demo", "users")
                .allowFiltering()
                .where()
                .and(QueryBuilder.eq("firstname", firstname))
                .limit(1);

        List<User> select = cassandraTemplate.select(query, User.class);

        return select.isEmpty() ? empty() : of(select.get(0));
    }

}
