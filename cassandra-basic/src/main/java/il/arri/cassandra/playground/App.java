package il.arri.cassandra.playground;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import il.arri.cassandra.playground.model.User;
import il.arri.cassandra.playground.repository.CassandraUserRepository;
import il.arri.cassandra.playground.repository.UserRepository;

import java.util.concurrent.ExecutorService;

import static java.lang.System.out;
import static java.util.concurrent.Executors.newSingleThreadExecutor;

/**
 * @author Arri Goldberg
 */
public class App {
    public static void main(String[] args) {
        //
        // Cluster setup
        //
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = cluster.connect("demo");

        ExecutorService service = newSingleThreadExecutor();

        //
        // Firing some queries via UserRepo
        //
        UserRepository userRepository = new CassandraUserRepository(session);
        User bob = userRepository.get("Golda");

        //
        // Just a check of the result
        //
        try {
            assert (bob.getEmail().equals("golda.katz@gmail.il"));
            assert (bob.getFirstName().equals("Golda"));
            assert (bob.getAge().equals(18));
        } finally {
            //
            // Turn off the light asynchronously
            //
            cluster.closeAsync().addListener(() -> {
                out.println("Done!");
                service.shutdown();
            }, service);
        }
    }
}
