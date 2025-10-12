package org.bbdev.spring.service;

import org.bbdev.spring.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final UserRepository userService;

    public CompanyService(UserRepository userService) {
        this.userService = userService;
    }
}
