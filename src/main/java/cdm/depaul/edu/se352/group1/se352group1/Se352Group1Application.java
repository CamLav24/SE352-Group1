package cdm.depaul.edu.se352.group1.se352group1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Se352Group1Application {

    public static void main(String[] args) {
        SpringApplication.run(Se352Group1Application.class, args);
    }

    @GetMapping("/")
    public String index() {

        return "Welcome to the Spring Boot application";

    }

}
