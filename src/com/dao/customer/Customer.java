package com.dao.customer;

import com.beanClasses.CustomerBean;
import com.exception.BusNotFoundException;
import com.exception.CustomerException;

public interface Customer {

	public String loginCustomer(String email,String password) throws CustomerException;
	
	public  String registerCustomer(CustomerBean customer);

    public void bookTicket(String startCity,String endCity) throws BusNotFoundException ;
    
    public void seatBook(String BusName,Integer seatNo,String email,String Password,String date);
    
    public void cancelTicke(String busName,String date,int seatNo);
    
    public void showOurServices() throws BusNotFoundException;
    
}
