package com.useCases.administrator;

import java.util.Scanner;

import com.dao.administrator.AdministratorImplements;
import com.exception.TicketNotBookedYet;

public class ShowAllTicket {

	public static void showAllTicket() {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter date in 'YY:MM;DD' formate..");
		String date = sc.next();
		
		AdministratorImplements obj = new AdministratorImplements();
		try {
			obj.totalTicketBooked(date);
		} catch (TicketNotBookedYet e) {
			System.out.println(e.getMessage());
		}
		
	}

}
