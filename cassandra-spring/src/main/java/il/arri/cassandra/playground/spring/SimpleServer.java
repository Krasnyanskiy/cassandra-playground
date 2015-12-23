package il.arri.cassandra.playground.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Arri Goldberg
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SimpleServer {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SimpleServer.class).run(args);
    }
}
