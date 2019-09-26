package com.technardiot.rnd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.technardiot.rnd.dao.CustomerRepo;
import com.technardiot.rnd.model.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepo repo;	
	
	@GetMapping(path="/customers", produces= {"application/json", "application/xml"})
	@ResponseBody
	public List<Customer> getCustomers()
	{
		return repo.findAll();
	}
	
	@GetMapping("/customer/{tid}")
	@ResponseBody
	public Optional<Customer> getCustomer(@PathVariable("tid") int tid)
	{
		return repo.findById(tid);
	}
	
	@PostMapping("customer")
	public Customer addCustomer(Customer customer)
	{
		repo.save(customer);
		return customer;
	}
	
	@PutMapping(path="/customer", consumes= {"application/json", "application/xml"})
	public Customer updateOrSaveCustomer(@RequestBody Customer customer)
	{
		repo.save(customer);
		return customer;
	}
	
	@DeleteMapping("/customer/{tid}")
	public String deleteCustomer(@PathVariable int tid)
	{
		Customer cus = repo.getOne(tid);
		repo.delete(cus);
		return "Deleted";
	}	
}