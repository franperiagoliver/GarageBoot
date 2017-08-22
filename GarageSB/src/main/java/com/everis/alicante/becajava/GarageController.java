package com.everis.alicante.becajava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/garageController")
@Scope("session")
public class GarageController {
	
	
	@RequestMapping(value = { "","/getMenu" }, method = RequestMethod.GET)
	public ModelAndView  getMenu() {
		 
		ModelAndView view=new ModelAndView();
		view.addObject("param", "param1");
		view.setViewName("menu");
		
		return view;
	
	}	
	
	@RequestMapping(value = { "/getBookings" }, method = RequestMethod.GET)
	public ModelAndView  getBookings() throws IOException {
		 
		
		URL url = new URL("http://localhost:8080/garage/bookings");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

		return null;
	
	}	
	
	


}
