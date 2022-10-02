package com.dao.administrator;

import com.beanClasses.BusDetailsBean;
import com.exception.BusNotFoundException;
import com.exception.TicketNotBookedYet;

public interface Administrator {

	public String addBusDetails(BusDetailsBean b);
	
	public void totalTicketBooked(String date) throws TicketNotBookedYet;
	
	public void showAllTicketBookedByBusName(String date,String busName) throws TicketNotBookedYet;
	
	public String changeBusEndCity(String busName,String endCity)throws BusNotFoundException;

	public String changeBusTiming(String newDepartureTime,String newArrivalTime,String busName) throws BusNotFoundException;
	
}

