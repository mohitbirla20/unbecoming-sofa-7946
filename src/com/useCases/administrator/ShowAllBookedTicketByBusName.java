package com.useCases.administrator;

import java.util.Scanner;

import com.dao.administrator.AdministratorImplements;
import com.exception.TicketNotBookedYet;

public class ShowAllBookedTicketByBusName {

	public static void showAllTicketByBusName() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter date in 'YY:MM:DD' formate");
		String date = sc.next();
		
		System.out.println("Enter BusName which you booked");
		String BusName = sc.next();
		
		AdministratorImplements obj = new AdministratorImplements();
		
		try {
			obj.showAllTicketBookedByBusName(date, BusName);
		} catch (TicketNotBookedYet e) {
			System.out.println("Ticket not booked");
		}
		
	}
	
}
