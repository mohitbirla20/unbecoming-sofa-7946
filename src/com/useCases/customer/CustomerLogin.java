package com.useCases.customer;

import java.util.Scanner;

import com.dao.customer.CustomerImplements;
import com.exception.CustomerException;

public class CustomerLogin {
    
	public static String customerLogin() {
	    
		String massage = "Account does not exist..";
		
		CustomerImplements obj = new CustomerImplements();
        Scanner sen = new Scanner(System.in);
        
        System.out.println("Enter your email id");
        String gmail = sen.next();
        
        
        System.out.println("Enter your password");
        String pass = sen.next();
        
        
        try {
			String name = obj.loginCustomer(gmail, pass);
			massage = "Welcome back to our travels "+name;
		} catch (CustomerException e) {
			massage = e.getMessage();
		}
        
        return massage;
	}
	
}
