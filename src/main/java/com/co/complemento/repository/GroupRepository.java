package com.co.complemento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.co.complemento.domain.Brand;

@Component
public interface GroupRepository extends CrudRepository<Brand, Long> {

}
