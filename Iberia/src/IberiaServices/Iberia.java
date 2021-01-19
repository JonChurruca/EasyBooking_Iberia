package IberiaServices;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import data.Flight;
import data.FlightAssambler;
import data.FlightDTO;


public class Iberia extends Thread{
	
	private static String DELIMITER = "#";
	
	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;

	
	//private FlightAssambler flightAssambler; 
	private String flight; 
	
	private List<Flight> defaultFlights = new ArrayList<>();

	//private List<Flight> selectedFlights;
	
	//private List<FlightDTO> selectedFlightsDTO;
	
	Flight f1 = new Flight(1111, "12-02-2020", "12-02-2020", "13:00", "11:30", "Madrid", "London", "Iberia");
	Flight f2 = new Flight(1112, "12-02-2020", "12-02-2020", "16:30", "14:00", "London", "Madrid", "Iberia");
	


			
	public Iberia(Socket socket) {
		defaultFlights.add(f1);
		defaultFlights.add(f2);
		try {
			this.tcpSocket = socket;
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (IOException e) {
			System.err.println("# Iberia - TCPConnection IO error:" + e.getMessage());
		}
	}
	
	public void run() {
		try {
			String pattern = this.in.readUTF();			
			//selectedFlightsDTO = this.selectFlights(pattern);
			flight = this.selectFlights(pattern); 
			if (flight!= null)
			{
				this.out.writeUTF(flight);					
			}
		} catch (EOFException e) {
		} catch (IOException e) {
		} finally {
			try {
				tcpSocket.close();
			} catch (IOException e) {
			}
		}
	}
	
	public String selectFlights(String pattern){
		//selectedFlights = new ArrayList<>(); 
		//selectedFlightsDTO = new ArrayList<>(); 
		
		if (pattern != null && !pattern.trim().isEmpty()) {
			try {
				StringTokenizer tokenizer = new StringTokenizer(pattern, DELIMITER);		
				String depAirport = tokenizer.nextToken();
				String arrivalAirport = tokenizer.nextToken();
				String depDate = tokenizer.nextToken();
				//System.out.println(depAirport);
				//System.out.println(arrivalAirport);
				//System.out.println(depDate);

				for (Flight dflight : defaultFlights) {
					
					if (dflight.getArrivalAirport().equals(arrivalAirport) && dflight.getDepAirport().equals(depAirport) && dflight.getDepDate().equals(depDate)) {
						
						flight = dflight.getFlightID() + "#" +dflight.getAirline()+"#"+ dflight.getArrivalDate()+"#"+ 
						dflight.getDepDate()+"#"+ dflight.getArrivalTime()+"#"+dflight.getDepTime()+"#"+dflight.getDepAirport()+"#"+dflight.getArrivalAirport(); 
						System.out.println(flight);
					}	
				}
				
			} catch (Exception e) {
				System.err.println("   # API error:" + e.getMessage());
			}
		}
		
		//selectedFlightsDTO = flightAssambler.assemble(selectedFlights); 
		
		return flight; 
	}


}
