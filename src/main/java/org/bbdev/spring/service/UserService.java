package org.bbdev.spring.service;

import lombok.RequiredArgsConstructor;
import org.bbdev.spring.database.entity.Company;
import org.bbdev.spring.database.repository.CrudRepository;
import org.bbdev.spring.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

}
