package com.code;

import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int customerIdCounter;
	
	public Customer(String firstName,String lastName,String email,String password,double registrationAmount,LocalDate dob,ServicePlan plan) {	
		this.customerId=customerIdCounter;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.password=password;
		this.registrationAmount=registrationAmount;
		this.dob=dob;
		this.plan=plan;
		customerIdCounter++;
	}
	
	public Customer(String email) {
		super();
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	static {
		customerIdCounter=1000;
	}
	
	
	
	@Override
	public String toString() {
		return "\nCustomerId=" + customerId + "\nFirstName=" + firstName + "\nLastName=" + lastName + "\nEmail="
				+ email + "\nPassword=" + password + "\nRegistrationAmount=" + registrationAmount + "\nDate of Birth=" + dob
				+ "\nService Plan=" + plan ;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Customer) {
//			System.out.println("In customer equals");
			return this.email.equals(((Customer)o).email);
		}
		return false;
	}
	
	@Override
	public int compareTo(Customer anotherCustomer) {
		return this.email.compareTo(anotherCustomer.email);
	}
	
	
}
