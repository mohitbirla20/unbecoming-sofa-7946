package com.mainMethod;

import java.util.Scanner;

import com.useCases.administrator.AddBusDetails;
import com.useCases.administrator.ChangeBusEndCity;
import com.useCases.administrator.ChangeBusTiming;
import com.useCases.administrator.ShowAllBookedTicketByBusName;
import com.useCases.administrator.ShowAllTicket;
import com.useCases.customer.CancelTicket;
import com.useCases.customer.CustomerLogin;
import com.useCases.customer.CustomerRegistration;
import com.useCases.customer.SeatBooking;
import com.useCases.customer.ShowOurServices;
import com.useCases.customer.TicketBooking;

public class Main {

	public static void main(String[] args) {

		while(true) {
			
			System.out.println("*********************************************************");
			System.out.println("1. Customer");
			System.out.println("2. Administrator");
			System.out.println("3. Exist");
			System.out.println("*********************************************************");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			
			if(num==1) {
				
			  while(true) {
				System.out.println("*********************************************************");
				System.out.println("1. Registration");
				System.out.println("2. login");
				System.out.println("3. Exist");
				System.out.println("*********************************************************");
				int km = sc.nextInt();
				
				if(km==1) {
				  String massage = CustomerRegistration.customerRegistration();
           	      System.out.println(massage);
           	      
				    if(massage.equals("Registration succesfull")) {
				    	System.out.println("please Login for continue");
	            	    String name = CustomerLogin.customerLogin();
	            	    System.out.println(name);
	            	    
	            	    // after login successful..
	            	    
	            	    if(!name.equals("Customer not Found..")) {
	            	    	while(true) {
	        				System.out.println("*********************************************************");
	            	    	System.out.println("1. Book Ticket");
	            	    	System.out.println("2. Cancel Ticket");
	            	    	System.out.println("3. show services");
	            	    	System.out.println("4. Exist");
	        				System.out.println("*********************************************************");
	            	    	
	            	    	int kj = sc.nextInt();
	            	    	if(kj==1) {
	            	    		String mass = TicketBooking.ticketbooking();
	                            if(mass.equals("Succes"))
	                                  SeatBooking.seatBooked();
	                            else
	                            	System.out.println("For Root This our services not available");
	            	    	}
	            	    	if(kj==2) 
	            	    		CancelTicket.cancelTicket();
	            	    	
	            	    	if(kj==3)
	            	    		ShowOurServices.showServices();
	            	    	
	            	    	if(kj==4) {
	            	    		//System.out.println("Thank You For Visiting");
	            	    		break;
	            	    	}
	            	    }
	            	  }
				   }
				
				}
				
				
				if(km==2) {
					   System.out.println("please Login for continue");
	            	   String name = CustomerLogin.customerLogin();
	          	       System.out.println(name);
	          	       
	          	     // after login successful..
	          	      
	            	    if(!name.equals("Customer not Found..")) {
	            	    	while(true) {
	            			System.out.println("*********************************************************");
	            	    	System.out.println("1. Book Ticket");
	            	    	System.out.println("2. Cancel Ticket");
	            	    	System.out.println("3. show services");
	            	    	System.out.println("4. Exist");
	        				System.out.println("*********************************************************");
	            	    	
	            	    	int kl = sc.nextInt();
	            	    	if(kl==1) {
	            	    		String massage = TicketBooking.ticketbooking();
	                            if(massage.equals("Succes"))
	                                  SeatBooking.seatBooked();
	                            else
	                            	System.out.println("For Root This our services not available");
	            	    	}
	            	    	if(kl==2) 
	            	    		CancelTicket.cancelTicket();
	            	    	
	            	    	if(kl==3)
	            	    		ShowOurServices.showServices();
	            	    	
	            	    	if(kl==4) {
	            	    		//System.out.println("Thank You For Visiting");
	            	    		break;
	            	    	}
	            	      	
	            	    }
	          	      }
				}
				
				if(km==3) {
					System.out.println("thank you for visiting");
					break;
				
			   }	
			}
		}
			// for administrator.
			if(num==2) {
				
				System.out.println("Enter your username");
				String username = sc.next();
				
				System.out.println("Enter your password");
				String password = sc.next();
			 if(username.equals("mohit20") && password.equals("mohit12")) {
				 while(true) {
				System.out.println("*********************************************************");
				System.out.println("1. Add new Bus");
				System.out.println("2. show all booked ticket by bus name");
				System.out.println("3. show all booked ticket");
				System.out.println("4. Change the city where bus stop");
				System.out.println("5. Change the Bus timing");
				System.out.println("6. Exist");
				System.out.println("*********************************************************");
				int tl = sc.nextInt();
				if(tl == 1) 
					System.out.println(AddBusDetails.addBusDetails());
				
				if(tl == 2)
					ShowAllBookedTicketByBusName.showAllTicketByBusName();
				
				if(tl == 3)
					ShowAllTicket.showAllTicket();
				
				if(tl==4)
					ChangeBusEndCity.changeBusEndCity();
				
				if(tl==5) 
					ChangeBusTiming.changeBusTiming();
				
				if(tl==6)
					break;
				
				 }
			 }else
				 System.out.println("Wrong password");
			}
			
			//for existing
			if(num==3) {
				System.out.println("thank you for visiting");
				break;
			}
			
		}

	}
}
