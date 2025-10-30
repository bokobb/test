package org.bbdev.spring.database.repository;

import org.bbdev.spring.database.entity.Role;
import org.bbdev.spring.database.entity.User;
import org.bbdev.spring.dto.PersonalInfo;
import org.bbdev.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter filter);

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);

    void updateCompanyAndRole(List<User> users);
    void updateCompanyAndRoleNamed(List<User> users);
}
