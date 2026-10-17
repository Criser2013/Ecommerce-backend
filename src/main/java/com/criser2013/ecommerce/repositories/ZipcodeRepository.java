package com.criser2013.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;

import com.criser2013.ecommerce.models.Zipcode;

public interface ZipcodeRepository extends CrudRepository<Zipcode, String>{
    public Zipcode findFirstByZipcode(String zipcode);
}
