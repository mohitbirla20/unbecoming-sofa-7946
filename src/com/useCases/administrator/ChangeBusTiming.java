package com.useCases.administrator;

import java.util.Scanner;

import com.dao.administrator.AdministratorImplements;
import com.exception.BusNotFoundException;

public class ChangeBusTiming {

	public static void changeBusTiming() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter BusName for time changed");
		String name = sc.next();
		
		System.out.println("Enter new departure time");
		String newDeparturetime = sc.next();
		
		System.out.println("Enter new arrival time");
		String newarrivaltime = sc.next();
		
		AdministratorImplements obj = new AdministratorImplements();
		
		try {
			System.out.println(obj.changeBusTiming(newDeparturetime, newarrivaltime, name));
		} catch (BusNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
