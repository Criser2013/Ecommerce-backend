package com.criser2013.ecommerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.criser2013.ecommerce.models.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
    public List<Address> findByUserId(Long userId);

    public Address findFirstByUserIdAndIsDefault(Long userId, Boolean isDefault);
}
