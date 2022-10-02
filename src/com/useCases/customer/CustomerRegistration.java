package com.useCases.customer;
import java.util.Scanner;

import com.beanClasses.CustomerBean;
import com.dao.customer.CustomerImplements;

public class CustomerRegistration {

	public static String customerRegistration() {
       
		CustomerImplements obj = new CustomerImplements();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter you name");
        String name = sc.nextLine();
        
        Scanner tc = new Scanner(System.in);
        System.out.println("Enter your mobile no.");
        String mobile = tc.next();
        
        System.out.println("Enter your gender");
        String gender = tc.next();
        
        System.out.println("Enter your city");
        String city = tc.next();
        
        System.out.println("Enter your email id");
        String email = tc.next();
        
        System.out.println("Enter password");
        String password = tc.next();
        
        System.out.println("Enter your age");
        int age = tc.nextInt();
        
        CustomerBean customer = new CustomerBean(name, mobile, gender, city, email, password, age);   		
		
        String massage = obj.registerCustomer(customer);
        
        
        return massage;
        
	}
     
	
	
}
