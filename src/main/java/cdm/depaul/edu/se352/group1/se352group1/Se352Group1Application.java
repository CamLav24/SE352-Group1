package cdm.depaul.edu.se352.group1.se352group1;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Log4j2
@EnableCaching
public class Se352Group1Application {

    public static void main(String[] args) {
        SpringApplication.run(Se352Group1Application.class, args);
    }


//    @GetMapping("/")
//    public String index() {
//
//        return "Welcome to the Spring Boot application";
//
//    }



}
