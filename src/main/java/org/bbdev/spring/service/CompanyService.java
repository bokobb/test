package org.bbdev.spring.service;

import org.bbdev.spring.database.entity.Company;
import org.bbdev.spring.database.repository.CrudRepository;
import org.bbdev.spring.database.repository.UserRepository;
import org.bbdev.spring.dto.CompanyReadDto;
import org.bbdev.spring.listener.entity.AccessType;
import org.bbdev.spring.listener.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    private final CrudRepository<Integer, Company> companyRepository;
    private final UserRepository userService;
    private final ApplicationEventPublisher eventPublisher;

    public CompanyService(CrudRepository<Integer, Company> companyRepository,
                          UserRepository userService, ApplicationEventPublisher eventPublisher) {
        this.companyRepository = companyRepository;
        this.userService = userService;
        this.eventPublisher = eventPublisher;
    }
    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id)
                .map(entity -> {
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.id());
                });
    }
}
