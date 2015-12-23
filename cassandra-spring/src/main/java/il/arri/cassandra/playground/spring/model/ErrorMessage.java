package il.arri.cassandra.playground.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Alexander Krasniansky
 */
@Data
@AllArgsConstructor
public class ErrorMessage {
    private String error;
}
