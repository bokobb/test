package org.bbdev.spring.database.repository;

import org.bbdev.spring.database.entity.User;
import org.bbdev.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter filter);
}
