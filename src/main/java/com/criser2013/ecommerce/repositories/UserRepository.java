package com.criser2013.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;

import com.criser2013.ecommerce.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findFirstByEmailUser(String email);

    public User findFirstByDni(String dni);
}
