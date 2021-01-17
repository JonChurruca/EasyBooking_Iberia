package data;


import java.util.ArrayList;
import java.util.List;

public class Flight {
	

	private Integer flightID; 
	private String airline; 
	private String arrivalDate; 
	private String depDate; 
	private String arrivalTime; 
	private String depTime; 
	private String depAirport; 
	private String arrivalAirport;
	

	
	//CONSTRUCTOR
	public Flight(Integer flightID, String arrivalDate, String depDate, String arrivalTime, String depTime, String depAirport,
			String arrivalAirport, String airline) {
		
		this.flightID = flightID; 
		this.arrivalDate = arrivalDate;
		this.depDate = depDate;
		this.arrivalTime = arrivalTime;
		this.depTime = depTime;
		this.depAirport = depAirport;
		this.arrivalAirport = arrivalAirport;
		this.airline = airline; 
	}

	
	// GETTERS AND SETTERS 
	
	public Integer getFlightID() {
		return flightID;
	}

	public void setFlightID(Integer flightID) {
		this.flightID = flightID;
	}


	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public String getDepDate() {
		return depDate;
	}


	public void setDepDate(String depDate) {
		this.depDate = depDate;
	}


	public String getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public String getDepTime() {
		return depTime;
	}


	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}


	public String getDepAirport() {
		return depAirport;
	}


	public void setDepAirport(String depAirport) {
		this.depAirport = depAirport;
	}


	public String getArrivalAirport() {
		return arrivalAirport;
	}


	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}




	public String getAirline() {
		return airline;
	}


	public void setAirline(String airline) {
		this.airline = airline;
	} 
	

	@Override
	public String toString() {
		return "Flight [flightID=" + flightID + ", airline=" + airline + ", arrivalDate=" + arrivalDate + ", depDate="
				+ depDate + ", arrivalTime=" + arrivalTime + ", depTime=" + depTime + ", depAirport=" + depAirport
				+ ", arrivalAirport=" + arrivalAirport + "]";
	}
	
	
	
	
	
	

}
