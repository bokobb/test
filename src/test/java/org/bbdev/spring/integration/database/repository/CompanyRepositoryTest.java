package org.bbdev.spring.integration.database.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.bbdev.spring.database.entity.Company;
import org.bbdev.spring.database.repository.CompanyRepository;
import org.bbdev.spring.integration.annotation.IT;
import org.junit.jupiter.api.Test;

import org.springframework.transaction.support.TransactionTemplate;

import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
//@Transactional
//@Rollback
//@Commit
class CompanyRepositoryTest {
    private static final Integer APPLE_ID = 5;
    private final EntityManager entityManager;
    private final TransactionTemplate transactionTemplate;
    private final CompanyRepository companyRepository;

    @Test
    void delete() {
        var maybeCompany = companyRepository.findById(APPLE_ID);
        assertTrue(maybeCompany.isPresent());
        maybeCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(APPLE_ID).isEmpty());
    }

    @Test
    void checkFindByQueries(){
        companyRepository.findByName("google");
        companyRepository.findByNameContainingIgnoreCase("a");
    }

    @Test
    void findById() {
        transactionTemplate.executeWithoutResult(tx -> {
                var company = entityManager.find(Company.class, 1);
                assertNotNull(company);
                assertThat(company.getLocales()).hasSize(2);
        });
    }

    @Test
    void save(){
        var company = Company.builder()
                .name("Facebook")
                .locales(Map.of(
                        "ru", "Facebook описание",
                        "en", "Facebook description"
                ))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }
}