package il.arri.cassandra.playground.spring.domain;

import lombok.Data;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;

/**
 * @author Arri Goldberg
 */
@Data
@Table
public class User implements Serializable {
    @Column private String firstName;
    @Column private String lastName;
    @Column private Integer age;
    @Column private String email;
    @PrimaryKey private String id;
}
