package com.useCases.administrator;

import java.util.Scanner;

import com.dao.administrator.AdministratorImplements;
import com.exception.BusNotFoundException;

public class ChangeBusEndCity {

	public static void changeBusEndCity() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter That bus name you want to change the root");
		String busname = sc.next();
		
		System.out.println("Enter new city name where this bus stop");
		String NewCity = sc.next();
		
		AdministratorImplements obj = new AdministratorImplements();
		
		try {
			System.out.println(obj.changeBusEndCity(busname, NewCity));
		} catch (BusNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
