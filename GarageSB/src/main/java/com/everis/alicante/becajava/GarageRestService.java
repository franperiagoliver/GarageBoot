package com.everis.alicante.becajava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.everis.alicante.becajava.domain.Booking;
import com.everis.alicante.becajava.dto.BookingDto;
import com.everis.alicante.becajava.garage.controller.ControladorGaraje;
import com.everis.alicante.becajava.garage.controller.ControladorGarajeImpl;



@RestController
@RequestMapping("/garage")
public class GarageRestService {
	
	ControladorGaraje controlador= new ControladorGarajeImpl();
	
	@RequestMapping(path="/bookings", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<BookingDto> getBooking() {			
		
		List<Booking> lista = controlador.listarReservas();
		
		List<BookingDto> bookings=new ArrayList<>();
		
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Booking booking = (Booking) iterator.next();
			BookingDto dto=new BookingDto();
			dto.setIdbooking(booking.getIdbooking());
			dto.setBookingdate(booking.getBookingdate());
			dto.setClient(booking.getClient().getNif());
			dto.setVehicle(booking.getVehicle().getVehicleplate());
			dto.setParkingplace(booking.getParkingplace().getParkingnumber());
			bookings.add(dto);
		}
			
		return bookings;
		
	}

}
