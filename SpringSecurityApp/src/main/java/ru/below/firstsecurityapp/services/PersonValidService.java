package ru.below.firstsecurityapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.below.firstsecurityapp.models.Person;
import ru.below.firstsecurityapp.repositories.PersonRepository;
import ru.below.firstsecurityapp.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonValidService implements UserDetailsService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonValidService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = Optional.ofNullable(personRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found")));
        return new PersonDetails(person.get());
    }
}
