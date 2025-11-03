package org.bbdev.spring.integration.service;

import lombok.RequiredArgsConstructor;
import org.bbdev.spring.ApplicationRunner;
import org.bbdev.spring.config.DatabaseProperties;
import org.bbdev.spring.database.entity.Company;
import org.bbdev.spring.dto.CompanyReadDto;
import org.bbdev.spring.integration.annotation.IT;
import org.bbdev.spring.listener.entity.EntityEvent;
import org.bbdev.spring.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class,
//initializers = ConfigDataApplicationContextInitializer.class)
//@ActiveProfiles("test")
//@SpringBootTest
@IT
@RequiredArgsConstructor
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class CompanyServiceIT {
    public static final Integer COMPANY_ID = 1;
    private final CompanyService companyService;
    private final DatabaseProperties databaseProperties;

    @Test
    void findById(){
        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID, null);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

    }

}
