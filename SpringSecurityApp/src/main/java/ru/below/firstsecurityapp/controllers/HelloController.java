package ru.below.firstsecurityapp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.below.firstsecurityapp.models.Person;
import ru.below.firstsecurityapp.repositories.PersonRepository;
import ru.below.firstsecurityapp.security.PersonDetails;
import ru.below.firstsecurityapp.services.AdminService;

@Controller
@AllArgsConstructor
public class HelloController {
    @Autowired
    private final PersonRepository repository;
    @Autowired
    private final AdminService adminService;
    @GetMapping("/hello")
    public String sayhello() {

        return "hello";
    }
    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "hello";

    }
    @GetMapping("/admin")
    public String adminPage() {
        adminService.doAdminStuff();
        return "admin";
    }
}
