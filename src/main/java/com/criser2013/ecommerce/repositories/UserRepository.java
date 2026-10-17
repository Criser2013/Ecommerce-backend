package com.criser2013.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;

import com.criser2013.ecommerce.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByEmail(String email);
}
