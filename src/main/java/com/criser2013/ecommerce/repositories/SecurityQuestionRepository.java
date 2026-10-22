package com.criser2013.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;

import com.criser2013.ecommerce.models.SecurityQuestion;

public interface SecurityQuestionRepository extends CrudRepository<SecurityQuestion, Long> {
}
