package com.wms.service;

import java.util.ArrayList;

import com.wms.model.CustomerAccount;


public interface ICustomer {
	public void addCustomer(CustomerAccount account);
	public ArrayList<CustomerAccount> getCustomerList();
	public void customerAccountDeleteById(String itemNo);
	public CustomerAccount updateCustomerById(int CustomerID,CustomerAccount customer);
	public CustomerAccount getCustomerByID(int CustomerID);
	public boolean isCustomerAvailable(int CustomerID);
	public ArrayList<CustomerAccount> getCustomerAccount();
	public ArrayList<CustomerAccount> searchCustomerById(String txt);
	public ArrayList<CustomerAccount> searchCustomerByName(String txt);
	public ArrayList<CustomerAccount> searchCustomerByType(String txt);
	public ArrayList<CustomerAccount> searchCustomerByEmail(String txt);
	public ArrayList<CustomerAccount> searchCustomerByMobile(String txt);
	
}
