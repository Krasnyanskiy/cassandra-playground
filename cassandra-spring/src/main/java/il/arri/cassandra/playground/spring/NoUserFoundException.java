package il.arri.cassandra.playground.spring;

import static java.lang.String.format;

/**
 * @author Arri Goldberg
 */
public class NoUserFoundException extends RuntimeException {
    public NoUserFoundException(String firstname) {
        super(format("No user found with name '%s'", firstname));
    }
}
