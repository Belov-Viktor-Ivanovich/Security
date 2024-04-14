package ru.below.firstsecurityapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.below.firstsecurityapp.models.Person;
import ru.below.firstsecurityapp.services.PersonValidService;

@Component
public class PersonValidator implements Validator {
    private final PersonValidService personValidService;
    @Autowired
    public PersonValidator(PersonValidService personValidService) {
        this.personValidService = personValidService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        try{
            personValidService.loadUserByUsername(person.getUsername());
        }catch (UsernameNotFoundException ignored){
            return;
        }
        errors.rejectValue("username", null, "Человек с таким пользователем существует");
    }

    @Override
    public Errors validateObject(Object target) {
        return Validator.super.validateObject(target);
    }
}
