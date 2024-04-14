package ru.below.firstsecurityapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.below.firstsecurityapp.models.Person;

@SpringBootApplication
public class FirstSecurityAppApplication {

    public static void main(String[] args) {



        SpringApplication.run(FirstSecurityAppApplication.class, args);


    }

}
