package com.customers.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customers.domain.entity.Customer;

public interface ICategoriaRepository extends JpaRepository<Customer, Integer>{

}
