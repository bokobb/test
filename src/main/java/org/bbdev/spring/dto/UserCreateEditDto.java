package org.bbdev.spring.dto;

import lombok.AccessLevel;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import org.bbdev.spring.database.entity.Role;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Value
public class UserCreateEditDto {
    String username;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}
