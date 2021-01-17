package data;
import java.util.ArrayList;
import java.util.List;



public class FlightAssambler {
	
	
	public List<FlightDTO> assemble(List<Flight> flights) {
		List<FlightDTO> flightsDTO = new ArrayList<>();

		for (Flight f : flights) {
			flightsDTO.add(new FlightDTO(f.getFlightID(), f.getArrivalDate(), f.getDepDate(), f.getArrivalDate(), f.getDepDate(), f.getDepAirport(),
					f.getArrivalAirport(), f.getAirline()));
		}
		
		return flightsDTO;
	}

}
