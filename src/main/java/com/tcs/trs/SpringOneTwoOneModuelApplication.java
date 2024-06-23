package com.tcs.trs;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.tcs.trs.dto.AddressDTO;
import com.tcs.trs.dto.CustomerDTO;
import com.tcs.trs.exception.SBIBankException;
import com.tcs.trs.service.CustomerService;

@SpringBootApplication
public class SpringOneTwoOneModuelApplication implements CommandLineRunner  {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringOneTwoOneModuelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			//getCustomer();
			//addCustomer();
		    //updateAddress();
		//deleteCustomer();
	}
	
	
	public void getCustomer() {
		
		
		try {
			Integer customerId=1237;
			CustomerDTO customerDTO = customerService.getCustomer(customerId);
			System.out.println(customerDTO);
		} catch (SBIBankException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void addCustomer() {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setName("Needhi Yadav");
		customerDTO.setEmailId("nedhi@gmail.com");
		customerDTO.setDateOfBirth(LocalDate.parse("2002-09-10"));
		AddressDTO addressDTO= new AddressDTO();
		addressDTO.setAddressId(new Long(108));
		addressDTO.setCity("Gauspur");
		addressDTO.setStreet("Gali no-42");
		customerDTO.setAddress(addressDTO);
		Integer customer = customerService.addCustomer(customerDTO);
		
		
		String customerAddSuccsfuly = environment.getProperty("UserInterface.CUSTOMER_ADDED" ) +" : "+customer; 
	
		System.out.println(customerAddSuccsfuly);
		
	}
	
	public void updateAddress() {
		
		Integer customerId=1241;
		AddressDTO addressDTO= new AddressDTO();
		addressDTO.setCity("Varansi Gauspur");
		addressDTO.setStreet("Gali no- 15");
		try {
			customerService.updateAddress(customerId, addressDTO);
			System.out.println("Customer Address updated successfully");
		} catch (SBIBankException e) {
		e.printStackTrace();
		}
		
		
	}
	
	public void deleteCustomer() {
		Integer customerId=1239;
		try {
			customerService.deleteCustomer(customerId);
			System.out.println("Customer deleted Successfully with customerId: "+customerId);
		} catch (SBIBankException e) {
			e.printStackTrace();
		}
		
	}

}
