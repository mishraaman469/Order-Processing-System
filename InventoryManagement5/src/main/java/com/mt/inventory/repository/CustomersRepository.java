package com.mt.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.inventory.entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
