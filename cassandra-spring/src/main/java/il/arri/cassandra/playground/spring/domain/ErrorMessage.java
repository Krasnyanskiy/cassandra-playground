package il.arri.cassandra.playground.spring.domain;

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
