package dashboard;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PreDestroy;
import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }

}