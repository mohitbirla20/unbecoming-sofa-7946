package com.dao.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beanClasses.CustomerBean;
import com.utility.DBUtil;
import com.exception.BusNotFoundException;
import com.exception.CustomerException;

public class CustomerImplements implements Customer{

	
	@Override
	public String registerCustomer(CustomerBean c) {
       
		String massage = "Registration faild..";
        
        try(Connection conn = DBUtil.provideConnection()){
    	   
        	PreparedStatement ps = conn.prepareStatement
        			           ("insert into customerDetails(name,mobile,gender,address,email,password,age) values(?,?,?,?,?,?,?)");
        
        	ps.setString(1, c.getName());
        	ps.setString(2,c.getMobile());
        	ps.setString(3,c.getGender());
        	ps.setString(4,c.getCity());
        	ps.setString(5,c.getEmail());
        	ps.setString(6,c.getPassword());
        	ps.setInt(7,c.getAge());
        	
        	int x= ps.executeUpdate();
            if(x>0) 
            	massage = "Registration succesfull";
            
        }catch (SQLException e) {
               massage = e.getMessage();
        }
        
		return massage;
   }
	
	
	
	
	@Override
	public  String loginCustomer(String email, String password) throws CustomerException{
       
		String name = null;
        
       try(Connection conn = DBUtil.provideConnection()){
    	  
    	   PreparedStatement ps = conn.prepareStatement
    			       ("select name from customerDetails where email=? and password=?");
    	   ps.setString(1, email);
    	   ps.setString(2, password);
           
    	   ResultSet rs = ps.executeQuery();

    	   if(rs.next()) {
    	   name = rs.getString("name");
    	   }
    	   else 
    		   throw new CustomerException("Customer not Found..");
    		   
    	   
       }catch (SQLException e) {
             throw new CustomerException(e.getMessage());
       }
        
		return name;
	}



	@Override
	public void bookTicket(String startCity, String endCity) throws BusNotFoundException {

		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement
					("select * from busdetails where busStart=? and busEnd=?");
			
		   ps.setString(1, startCity);
		   ps.setString(2, endCity);
		   
		   ResultSet rs = ps.executeQuery();
		   
		   /* when root found display all details to the customer */
		   int count = 1;
		   if(rs.next()) {
			   
			   System.out.println("Details of Bus "+count++);
			   System.out.println("Bus Name : "+rs.getString("busName"));
			   System.out.println("Bus Start from : "+rs.getString("busStart"));
			   System.out.println("Bus Stop at : "+rs.getString("busEnd"));
			   System.out.println("Bus type : "+rs.getString("busType"));
			   System.out.println("Total Seats : "+rs.getString("totalSeats"));
			   System.out.println("Bus Departure time : "+rs.getString("departureTime"));
			   System.out.println("Bus arrival time : "+rs.getString("arrivaleTime"));
			   System.out.println("**********************************************************");

		   }else
			   throw new BusNotFoundException("Sorry for this root our service not availble");
			
		} catch (SQLException e) {
			throw new BusNotFoundException(e.getMessage());
		}
		
		
	}



	
	@Override
	public void seatBook(String BusName,Integer seatNo,String email,String Pass,String date) {
		
		  try(Connection conn = DBUtil.provideConnection()) {
			
			  
			// for checking seat booked or not 
				PreparedStatement ps3 = conn.prepareStatement
						  ("select * from ticketBooked where busName=? and issueDate=? and seatNo=?;");
				ps3.setString(1, BusName);
				ps3.setString(2, date);
				ps3.setInt(3, seatNo);
				
				ResultSet ts = ps3.executeQuery();
			    if(ts.next()) {
			    	System.out.println("Seat already Booked please choose diff seatNo");
			    	return;
			    }
			  
			  
			PreparedStatement ps = conn.prepareStatement
					 ("select * from customerdetails where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, Pass);
			
			ResultSet rs = ps.executeQuery();
					
		    
			if(rs.next()) {
				
				PreparedStatement ps2 = conn.prepareStatement("insert into ticketBooked values(?,?,?,?,?,?,?,?,?,?,?)");
				ps2.setInt(1, rs.getInt("id"));
				ps2.setString(2, rs.getString("name"));
				ps2.setString(3, rs.getString("mobile"));
				ps2.setString(4, date);
				ps2.setString(5, rs.getString("gender"));
				ps2.setString(6, rs.getString("address"));
				ps2.setString(7, rs.getString("email"));
				ps2.setString(8, rs.getString("password"));
				ps2.setInt(9, rs.getInt("age"));
				ps2.setString(10,BusName);
				ps2.setInt(11,seatNo);

				int x = ps2.executeUpdate();
				
				if(x>0) {
                   System.out.println("Ticket Booked Happy Journy..");
				}
			}else {
				System.out.println("Please Enter Correct email or password.");
				System.out.println("Please try again.");
			}
			
		    } catch (SQLException e) {
                  System.out.println(e.getMessage());
		   }
		
		
	}



	@Override
	public void cancelTicke(String busName, String date, int seatNo) {

	             
	       try (Connection conn = DBUtil.provideConnection()){
			
	    	   PreparedStatement ps4 = conn.prepareStatement
	    			   ("delete from ticketBooked where busName=? and issueDate=? and seatNo=?");
	    	  
	    	   ps4.setString(1, busName);
	    	   ps4.setString(2, date);
	    	   ps4.setInt(3, seatNo);
	    	   
	    	   int x = ps4.executeUpdate();
	    	   if(x>0) 
	    		   System.out.println("Ticke Canceled Successfully..");
	    	   else
	    		   System.out.println("please enter right details");
	    	   
		  } catch (SQLException e) {
                 System.out.println(e.getMessage());
		  }
	       
		
	}


	

	@Override
	public void showOurServices() throws BusNotFoundException {

		
        try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement
					("select * from busdetails");
			
		   
		   ResultSet rs = ps.executeQuery();
		   
		   /*  display all details to the customer */
		   int count = 1;
		  
		   while(rs.next()) {
			   
			   System.out.println("Details of Bus "+count++);
			   System.out.println("Bus Name : "+rs.getString("busName"));
			   System.out.println("Bus Start from : "+rs.getString("busStart"));
			   System.out.println("Bus Stop at : "+rs.getString("busEnd"));
			   System.out.println("Bus type : "+rs.getString("busType"));
			   System.out.println("Total Seats : "+rs.getString("totalSeats"));
			   System.out.println("Bus Departure time : "+rs.getString("departureTime"));
			   System.out.println("Bus arrival time : "+rs.getString("arrivaleTime"));
			   System.out.println("**********************************************************");
		   }
		   
		   
		} catch (SQLException e) {
			throw new BusNotFoundException(e.getMessage());
		}
		
        
        
	}



}
