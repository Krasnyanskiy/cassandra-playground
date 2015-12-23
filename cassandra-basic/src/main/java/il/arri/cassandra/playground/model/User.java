package il.arri.cassandra.playground.model;

import lombok.Data;

/**
 * @author Arri Goldberg
 */
@Data
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
}
