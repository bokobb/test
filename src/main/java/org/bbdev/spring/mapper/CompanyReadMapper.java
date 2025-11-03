package org.bbdev.spring.mapper;

import lombok.RequiredArgsConstructor;
import org.bbdev.spring.database.entity.Company;
import org.bbdev.spring.dto.CompanyReadDto;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto>{

    @Override
    public CompanyReadDto map(Company object) {
        return new CompanyReadDto(
                object.getId(),
                object.getName()
        );
    }
}
