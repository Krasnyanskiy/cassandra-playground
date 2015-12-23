package il.arri.cassandra.playground.spring.config;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import il.arri.cassandra.playground.repository.CassandraUserRepository;
import il.arri.cassandra.playground.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Arri Goldberg
 */
@Configuration
@PropertySource("classpath:cassandra.properties")
public class CassandraConfig {

    @Value("${app.cassandra.address}")
    private String contactPoint;

    @Value("${app.cassandra.keyspace}")
    private String keyspace;

    @Bean
    public Session session() {
        Cluster cluster = Cluster.builder().addContactPoint(contactPoint).build();
        return cluster.connect(keyspace);
    }

    @Bean
    public UserRepository userRepository() {
        return new CassandraUserRepository(session());
    }

}
