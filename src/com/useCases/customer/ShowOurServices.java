package com.useCases.customer;

import com.dao.customer.CustomerImplements;
import com.exception.BusNotFoundException;

public class ShowOurServices {

	public static void showServices() {
		
		CustomerImplements obj = new CustomerImplements();
		
		try {
			obj.showOurServices();
		} catch (BusNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
