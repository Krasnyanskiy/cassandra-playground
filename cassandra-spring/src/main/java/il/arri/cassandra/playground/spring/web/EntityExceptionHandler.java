package il.arri.cassandra.playground.spring.web;

import il.arri.cassandra.playground.spring.NoUserFoundException;
import il.arri.cassandra.playground.spring.model.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author Arri Goldberg
 */
@ControllerAdvice
public class EntityExceptionHandler {

    @ExceptionHandler(NoUserFoundException.class)
    @ResponseStatus(value = NOT_FOUND)
    @ResponseBody public ResponseEntity<ErrorMessage> noUserFound(NoUserFoundException e) {
        return new ResponseEntity<ErrorMessage>(new ErrorMessage(e.getMessage()), NOT_FOUND);
    }

}
