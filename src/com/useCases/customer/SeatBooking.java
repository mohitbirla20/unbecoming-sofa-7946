package com.useCases.customer;

import java.util.Scanner;

import com.dao.customer.CustomerImplements;

public class SeatBooking {


	public static void seatBooked() {
		
		CustomerImplements obj = new CustomerImplements();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Enter BusName which one you choose..");
		String busName = sc.next();
		
		System.out.println("please Enter seatNo.");
		Integer seatno = sc.nextInt();
		
		System.out.println("Enter date. in 'YY:MM:DD' Formet");
		String date = sc.next();
		
		System.out.println("for confirmation enter your email and password.");
		System.out.println("First enter your email");
		String email = sc.next();
		
		System.out.println("Enter your password.");
		String password = sc.next();
		
		obj.seatBook(busName, seatno, email, password, date);
		
		
	}
	
}
