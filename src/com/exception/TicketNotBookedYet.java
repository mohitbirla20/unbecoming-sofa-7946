package com.exception;

public class TicketNotBookedYet extends Exception {

	public TicketNotBookedYet() {
		
	}
	
	
	public TicketNotBookedYet(String massage) {
		super(massage);
	}
	
	
}
