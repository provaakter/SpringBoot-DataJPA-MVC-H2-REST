package com.technardiot.rnd.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technardiot.rnd.model.Customer;

public interface CustomerRepo  extends JpaRepository<Customer, Integer>
{
	
}
