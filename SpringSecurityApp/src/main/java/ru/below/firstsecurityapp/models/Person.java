package ru.below.firstsecurityapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Setter
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Column(name = "id")
    private UUID id;

    @Column(name = "username", nullable = false)
    @Getter
    @NotEmpty(message = "Name should not be empty")
    private String username;

    @Column(name = "year_of_birth", nullable = false)
    @Getter
    @NotNull(message = "yearOfBirth should not be null")
    @Min(value = 1900,message = "Слишком маленькая дата")
    @Max(value = 2024,message = "Слишком большая дата")
    private int yearOfBirth;

    @Column(name = "password", nullable = false)
    @Getter
    @NotEmpty(message = "password should not be empty")
    private String password;
    @Column(name = "role", nullable = false)
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Role role;

    public Person(String tom, int i, String number) {
        this.username = tom;
        this.yearOfBirth = i;
        this.password = number;
    }
    public Person(String tom, int i) {
        this.username = tom;
        this.yearOfBirth = i;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return yearOfBirth == person.yearOfBirth && Objects.equals(id, person.id) && Objects.equals(username, person.username) && Objects.equals(password, person.password);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", userName='" + username + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", password='" + password + '\'' +
                ", role='" + role.toString() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, yearOfBirth, password);

    }
}
