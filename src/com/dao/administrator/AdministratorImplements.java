package com.dao.administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beanClasses.BusDetailsBean;
import com.exception.BusNotFoundException;
import com.exception.TicketNotBookedYet;
import com.utility.DBUtil;

public class AdministratorImplements implements Administrator{

	@Override
	public String addBusDetails(BusDetailsBean b) {
		
		String massage = "Bus details added..";
			
		try(Connection conn = DBUtil.provideConnection();) {
			
			PreparedStatement ps = conn.prepareStatement
					("insert into busDetails values(?,?,?,?,?,?,?)");
			
			ps.setString(1, b.getBusName());
			ps.setString(2, b.getBusStart());
			ps.setString(3, b.getBusEnd());
			ps.setString(4, b.getBusType());
			ps.setInt(5, b.getTotalSeats());
			ps.setString(6, b.getDepartureTime());
			ps.setString(7, b.getBusarrivalTime());
			
			int x = ps.executeUpdate();
			if(x>0)
				massage = "Bus details Added";
						
		} catch (SQLException e) {
             massage = e.getMessage();
		}

		
		return massage;
   }

	
	
	
	@Override
	public void totalTicketBooked(String date) throws TicketNotBookedYet{
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement
					("select * from ticketbooked where issueDate=? group by busName order by seatNo");
			ps.setString(1, date);
			
			ResultSet rs = ps.executeQuery();
			int count = 1;
			
			if(!rs.next())
				System.out.println("for this day Ticket Not booked.");
			
			while(rs.next()) {
				
				   System.out.println("Details of Bus "+count++);
				   System.out.println("Customer id : "+rs.getInt("customerid"));
				   System.out.println("Customer name : "+rs.getString("name"));
				   System.out.println("Mobile : "+rs.getString("mobile"));
				   System.out.println("Ticket Booked Date : "+rs.getDate("issueDate"));
				   System.out.println("Customer gender : "+rs.getString("gender"));
				   System.out.println("Customer address : "+rs.getString("address"));
				   System.out.println("customer email id : "+rs.getString("email"));
				   System.out.println("age : "+rs.getInt("age"));
				   System.out.println("Bus Name : "+rs.getString("busName"));
				   System.out.println("Seat No. : "+rs.getInt("seatNo"));
				   System.out.println("**********************************************************");

			}
			
		} catch (SQLException e) {
              throw new TicketNotBookedYet(e.getMessage());
		}
		
		
	}




	@Override
	public void showAllTicketBookedByBusName(String date, String busName) throws TicketNotBookedYet {

           try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement
					("select * from ticketbooked where issueDate=? and busName=? group by busName order by seatNo");
			ps.setString(1, date);
			ps.setString(2, busName);	
			
			ResultSet rs = ps.executeQuery();
			int count = 1;
			
			if(!rs.next())
				System.out.println("for this day Ticket Not booked.");
			
			while(rs.next()) {
				
				   System.out.println("Details of Bus "+count++);
				   System.out.println("Customer Id : "+rs.getInt("customerid"));
				   System.out.println("Customer Name : "+rs.getString("name"));
				   System.out.println("Customer Mobile No. : "+rs.getString("mobile"));
				   System.out.println("Ticket Booked Date : "+rs.getDate("issueDate"));
				   System.out.println("Gender : "+rs.getString("gender"));
				   System.out.println("Customer Address : "+rs.getString("address"));
				   System.out.println("Customer Email id : "+rs.getString("email"));
				   System.out.println("age : "+rs.getInt("age"));
				   System.out.println("Bus Name : "+rs.getString("busName"));
				   System.out.println("Seat No : "+rs.getInt("seatNo"));
				   System.out.println("**********************************************************");

			}
			
		} catch (SQLException e) {
              throw new TicketNotBookedYet(e.getMessage());
		}
		
		
		
	}




	@Override
	public String changeBusEndCity(String busName, String endCity) throws BusNotFoundException {
		
		String massage = "Bus City Not Changed";
				
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement
					("update busdetails set busEnd=? where busName=?");
			ps.setString(1, endCity);
			ps.setString(2, busName);
			
			int x = ps.executeUpdate();
			if(x>0)
				massage = "Bus Root Change Successful";
			
		} catch (SQLException e) {
             throw new BusNotFoundException("Bus Not Found.");
		}
		
		
		return massage;
	}




	@Override
	public String changeBusTiming(String newDepartureTime, String newArrivalTime,String busName) throws BusNotFoundException {
		String massage = "Bus Timing Not Changed";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement
					("update busdetails set departureTime=?, arrivaleTime=? where busName=?");
			ps.setString(1, newDepartureTime);
			ps.setString(2, newArrivalTime);
			ps.setString(3, busName);
			
			int x = ps.executeUpdate();
			if(x>0)
				massage = "Bus Timing Change Successful";
			
		} catch (SQLException e) {
             throw new BusNotFoundException("Bus Not Found.");
		}
		
		
		return massage;
	}


	
	
}

