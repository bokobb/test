package org.bbdev.spring.service;

import org.bbdev.spring.database.entity.Company;
import org.bbdev.spring.database.repository.CrudRepository;
import org.bbdev.spring.database.repository.TestRepository;
import org.bbdev.spring.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> crudRepository;
    private final TestRepository testRepository;

    public UserService(UserRepository userRepository,
                       CrudRepository<Integer, Company> crudRepository,
                       TestRepository testRepository) {
        this.userRepository = userRepository;
        this.crudRepository = crudRepository;
        this.testRepository = testRepository;
    }
}
