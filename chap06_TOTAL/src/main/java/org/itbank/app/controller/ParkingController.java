package org.itbank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/parking")
public class ParkingController {
	
	@Autowired
	ObjectMapper mapper;
	
	@RequestMapping("/parking")
	public void parkingHandle(@RequestParam(defaultValue="1") String addr) {
		System.out.println("parking");
		
		RestTemplate template = new RestTemplate();
		
		
	}

}
