package com.useCases.customer;

import java.util.Scanner;
import java.util.Set;

import com.dao.customer.CustomerImplements;
import com.exception.BusNotFoundException;

public class TicketBooking {

	public static String ticketbooking() {
		
		String massage = "Succes";
		CustomerImplements obj = new CustomerImplements();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("please Enter your current city");
		String startCity = sc.next();
		
		System.out.println("please Enter where you want to go..");
		String endCity = sc.next();
		
		try {
                    obj.bookTicket(startCity, endCity);
		  
		 
		} catch (BusNotFoundException e) {
			massage = "Sorry For This Root Our services not available";
		}
		
		return massage;
		
	}
	
}
