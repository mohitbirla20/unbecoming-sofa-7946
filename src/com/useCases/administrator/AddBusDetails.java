package com.useCases.administrator;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.beanClasses.BusDetailsBean;
import com.dao.administrator.AdministratorImplements;
import com.utility.DBUtil;

public class AddBusDetails {

	public static String addBusDetails() {
	    
		String massage = "Bus Details not added";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter bus name");
		String busName = sc.next();
		
		System.out.println("Enter Bus Start city");
		String busStartCity = sc.next();
		
		System.out.println("Enter Bus End City");
        String busEndCity = sc.next();
        
        System.out.println("Enter busType AC or non-Ac");
        String busType = sc.next();
        
        System.out.println("Enter Total seats inside bus Availble..");
        int totalSeats = sc.nextInt();
        
        System.out.println("Enter Departure time of bus");
        String dtime = sc.next();
        
        System.out.println("Enter Arrival time of bus");
        String atime = sc.next();
		
		BusDetailsBean bus = new BusDetailsBean(busName, busStartCity, busEndCity, busType, totalSeats, dtime, atime);
		AdministratorImplements obj = new AdministratorImplements();
		massage = obj.addBusDetails(bus);
		
		return massage;
	}
	
}
