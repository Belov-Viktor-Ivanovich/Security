package ru.below.firstsecurityapp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.below.firstsecurityapp.models.Person;
import ru.below.firstsecurityapp.services.RegistrationServise;
import ru.below.firstsecurityapp.util.PersonValidator;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final PersonValidator personValidator;
    private final RegistrationServise registrationServise;
    @Autowired
    public AuthController(PersonValidator personValidator, RegistrationServise registrationServise) {
        this.personValidator = personValidator;
        this.registrationServise = registrationServise;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }
    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person) {
        return "auth/registration";
    }
    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) {return "/auth/registration";}
        registrationServise.registerPerson(person);
        return "redirect:/auth/login";
    }
}
