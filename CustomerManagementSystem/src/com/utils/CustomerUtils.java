package com.utils;

import java.util.List;

import com.code.Customer;
import com.exception.InvalidEmailException;
import com.exception.InvalidPasswordException;

public class CustomerUtils {
	public static Customer findByEmail(String email,String password,List<Customer> list) throws InvalidEmailException,InvalidPasswordException
	{
		Customer customer=new Customer(email);
		int index=list.indexOf(customer);
		if(index!=-1) {
			if(password.equals((list.get(index)).getPassword())) {
				//System.out.println(list.get(index));
				return list.get(index);
			}else {
				throw new InvalidPasswordException("Invalid Password!.. Password does not match");
			}
		}else {
			throw new InvalidEmailException("Invalid Email!.. Email not Found");
		}	
	}
	
	public static void changePassword(String email,String oldPassword,String newPassword ,List<Customer> list) throws InvalidEmailException,InvalidPasswordException
	{
		Customer c=findByEmail(email, oldPassword, list);
		c.setPassword(newPassword);
		System.out.println("Password Changed successfully");
	}
}
