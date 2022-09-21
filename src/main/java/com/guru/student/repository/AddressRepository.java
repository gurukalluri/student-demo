package com.guru.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guru.student.entity.Address;


public interface AddressRepository  extends JpaRepository<Address, Integer>{

}
