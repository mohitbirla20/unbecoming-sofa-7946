package com.useCases.customer;

import java.util.Scanner;

import com.dao.customer.CustomerImplements;

public class CancelTicket {

	public static void cancelTicket() {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Bus Name");
		String busName = sc.next();
		
		System.out.println("Enter your issueDate.");
		String issueDate = sc.next();
		
		System.out.println("Enter your seatno.");
		int seatno = sc.nextInt();
		
		
		CustomerImplements obj = new CustomerImplements();
		obj.cancelTicke(busName, issueDate, seatno);
		
		
		
		
	}
	
}
