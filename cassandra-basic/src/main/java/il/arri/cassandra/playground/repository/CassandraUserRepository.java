package il.arri.cassandra.playground.repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import il.arri.cassandra.playground.model.User;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

import static java.lang.String.format;

/**
 * @author Arri Goldberg
 */
// @formatter:off
@AllArgsConstructor
public class CassandraUserRepository implements UserRepository {

    private Session session;

    @Override public ResultSetFuture create(@NonNull User user) {
        /*
        PreparedStatement statement = session.prepare(InsertUser);
        return session.executeAsync(statement.bind(
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getCity(),
                user.getEmail()));
        */
        throw new UnsupportedOperationException("Will be implemented soon");
    }

    @Override public ResultSetFuture update(@NonNull User user) {
        throw new UnsupportedOperationException("Will be implemented soon");
    }

    @Override public User get(@NonNull String name) {
        ResultSetFuture f = session.executeAsync(format("SELECT * FROM users WHERE firstname='%s' ALLOW FILTERING;", name));
        try {
            return ResultSetToUserConverter.convert(f.get(1L, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    // @formatter:on
    // ---------------------------------------------------------------------
    //                            Nested Classes
    // ---------------------------------------------------------------------

    private static class ResultSetToUserConverter {
        static User convert(ResultSet rs) {
            User user = new User();
            rs.forEach(new UserRowConsumer(user));
            return user;
        }
    }

    @AllArgsConstructor
    private static class UserRowConsumer implements Consumer<Row> {
        private User user;

        public void accept(Row row) {
            user.setId(row.getString("id"));
            user.setFirstName(row.getString("firstname"));
            user.setLastName(row.getString("lastname"));
            user.setAge(row.getInt("age"));
            user.setEmail(row.getString("email"));
        }
    }

}

/*

        Futures.addCallback(resultSetFuture, new FutureCallback<ResultSet>() {
            @Override
            public void onSuccess(final ResultSet result) {
                ctx.done();
                request();
            }

            @Override
            public void onFailure(final Throwable t) {
                // Could do better I suppose
                System.err.println("Error during request: " + t);
                ctx.done();
                request();
            }
        }, executorService);

 */
