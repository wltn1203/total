package org.itbank.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ParkingController {
	
	@Autowired
	ObjectMapper mapper;
	
	@RequestMapping("/parking")
	public ModelAndView parkListHandle() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("section", "parking");
		RestTemplate rt = new RestTemplate();
		String str = rt.getForObject(
				"http://openapi.seoul.go.kr:8088/6f66654142746530383254796c4859/json/GetParkInfo/1/1000", String.class);
		try {
			Map obj = mapper.readValue(str, Map.class);
			Map info = (Map) obj.get("GetParkInfo");
			mav.addObject("data", info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
