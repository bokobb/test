package org.bbdev.spring.service;

import lombok.RequiredArgsConstructor;
import org.bbdev.spring.database.repository.CompanyRepository;
import org.bbdev.spring.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

}
