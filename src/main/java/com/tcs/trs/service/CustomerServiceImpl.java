package com.tcs.trs.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.trs.dto.AddressDTO;
import com.tcs.trs.dto.CustomerDTO;
import com.tcs.trs.entity.Address;
//import com.tcs.trs.dto.CustomerDTO;
import com.tcs.trs.entity.Customer;
import com.tcs.trs.exception.SBIBankException;
import com.tcs.trs.repository.CustomerRepository;


@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDTO getCustomer(Integer customerId) throws SBIBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);		
		Customer customer = optional.orElseThrow(() -> new SBIBankException("Service.INVALID_CUSTOMERID"));	
		
		CustomerDTO customerDTO = new CustomerDTO();
		
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setName(customer.getName());
		customerDTO.setEmailId(customer.getEmailId());
		customerDTO.setDateOfBirth(customer.getDateOfBirth());	
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddressId(customer.getAddress().getAddressId());
		addressDTO.setCity(customer.getAddress().getCity());
		addressDTO.setStreet(customer.getAddress().getStreet());
		customerDTO.setAddress(addressDTO);
		return customerDTO;
	}

	@Override
	public Integer addCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setDateOfBirth(customerDTO.getDateOfBirth());
		customer.setEmailId(customerDTO.getEmailId());
		customer.setName(customerDTO.getName());	
		Address address = new Address();
		address.setAddressId(customerDTO.getAddress().getAddressId());
		address.setCity(customerDTO.getAddress().getCity());
		address.setStreet(customerDTO.getAddress().getStreet());	
		customer.setAddress(address);
		customerRepository.save(customer);	
		return customer.getCustomerId();
	}

	@Override
	public void updateAddress(Integer customerId, AddressDTO addressDTO) throws SBIBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new SBIBankException("Service.INVALID_CUSTOMERID"));		
		Address address = customer.getAddress();
		address.setCity(addressDTO.getCity());
		address.setStreet(addressDTO.getStreet());
		customerRepository.save(customer);
		
	}

	@Override
	public void deleteCustomer(Integer customerId) throws SBIBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new SBIBankException("Service.INVALID_CUSTOMERID"));
		customerRepository.delete(customer);
		//return customer.getCustomerId();
		
	}

}
