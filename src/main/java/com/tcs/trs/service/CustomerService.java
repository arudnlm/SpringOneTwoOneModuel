package com.tcs.trs.service;

import com.tcs.trs.dto.AddressDTO;
import com.tcs.trs.dto.CustomerDTO;
import com.tcs.trs.exception.SBIBankException;

public interface CustomerService {
	
public CustomerDTO getCustomer(Integer customerId) throws SBIBankException;	
	
	public Integer addCustomer(CustomerDTO customerDTO);	
	
	public void updateAddress(Integer customerId, AddressDTO addressDTO) throws SBIBankException;
	
	public void deleteCustomer(Integer customerId) throws SBIBankException;
	

}
