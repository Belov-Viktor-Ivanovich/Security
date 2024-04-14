package ru.below.firstsecurityapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ru.below.firstsecurityapp.models.Role;

@Service
public class AdminService {

    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('USER')")  //or (или) and (и)
    public void doAdminStuff() {
        System.out.println("Only admin here");
    }
}
