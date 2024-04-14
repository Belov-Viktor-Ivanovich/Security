package ru.below.firstsecurityapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.below.firstsecurityapp.models.Person;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
        Optional<Person> findByUsername(String firstname);
}
