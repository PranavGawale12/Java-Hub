package com.tester;

import com.code.Customer;
import com.exception.*;
import com.utils.CustomerUtils;
import com.utils.ValidationRules;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerTester {

	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in)){
		List<Customer> custList=new ArrayList<>();
		
		boolean exit=false;
		while(!exit) {
			System.out.println("==============================");
			System.out.println("Options:-\n1.Sign up\n2.Sign in\n3.Change password\n4.Unsubscribe Customer\n5.Display all customers\n0.exit");
			System.out.println("==============================");
			try {
				switch(sc.nextInt()) {
				case 1:
					System.out.println("Enter Customer details.\nFirstName,LastName,Email,Password,RegistrationAmount,DOB,Service Plan");
					custList.add(ValidationRules.validateAllException(sc.next(),sc.next(), sc.next(), sc.next(),sc.nextDouble(), sc.next(), sc.next(),custList));
					System.out.println("Customer added");
					break;
				case 2:
					System.out.println("Enter Email And Password");
					System.out.println(CustomerUtils.findByEmail(sc.next(), sc.next(), custList));
					break;
				case 3:
					System.out.println("Enter Email,old Password And new Password");
					CustomerUtils.changePassword(sc.next(), sc.next(), sc.next(), custList);
					break;
				case 4:
					System.out.println("Enter Email and Password to Unsubscribe");
					boolean removed=custList.remove(CustomerUtils.findByEmail(sc.next(), sc.next(), custList));
					if(removed) {
						System.out.println("Unsubscribed Successfully");
					}
					break;
				case 5:
					for(Customer c : custList) {
						System.out.println(c);
					}
					break;
				case 0:
					exit =true;
					break;
				}
			}catch(InvalidEmailException e) {
				System.out.println(e);
			}catch(InvalidPasswordException e) {
				System.out.println(e);
			}catch(InvalidInputException e) {
				System.out.println(e);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}

}
