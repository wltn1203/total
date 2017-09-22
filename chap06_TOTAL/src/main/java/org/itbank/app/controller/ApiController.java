package org.itbank.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/api")
public class ApiController {
	@Autowired
	ObjectMapper mapper;
	
	@RequestMapping("/01")
	public void api_01Handle( ) {
		System.out.println("api/01");
		// Spring에서 제공하는 RestTemplate객체를 사용하지 않는다면,
		try {
			URL url = new URL("http://openapi.seoul.go.kr:8088/6f66654142746530383254796c4859/json/SearchSTNBySubwayLineService/1/10/2/");
			Scanner sc = new Scanner(url.openStream(), "utf-8");
			String str ="";
			while(sc.hasNextLine()) {
				str += sc.nextLine();
			}
			System.out.println(str);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/02")
	public void api_02Handle(@RequestParam(defaultValue="1") String line) {
		System.out.println("api/02");
		// Spring에서 제공하는 RestTemplate객체를 사용하지 않는다면,
		RestTemplate template = new RestTemplate();
		// get 방식으로 요청결과를 얻어오고 싶으면,
		/*
		String resp = 
			template.getForObject("http://openapi.seoul.go.kr:8088/6f66654142746530383254796c4859/json/SearchSTNBySubwayLineService/1/10/"+line+"/", 
							String.class);
		*/
		String resp = 
				template.getForObject("http://openapi.seoul.go.kr:8088/6f66654142746530383254796c4859/json/SearchSTNBySubwayLineService/1/{a}/{b}/", 
								String.class, 5 , line);	// 가변길이 인자로 설정하는 형태는 path 에 설정한 이름이 중요하지 않다.
		// 인자설정을 Map으로 할 수도 있는데, 이때는 설정했던 이름이 의미가 있음.
		
		// 세팅해야되는 데이터들이 많다면,
		System.out.println(resp);
		// ObjectMapper 
		// (JSON 형태의 문자열 ==> 객체 : readValue )
		// (객체 ===> JSON 형태의 문자열 : writeValueAsString )
		try {
			Map obj = mapper.readValue(resp, Map.class);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	// RestTemplate, 특정경로로 요청을 보내고 거기서 응답을 받아볼수 있음.
	// 이메일 발송하는거 해보았는데, HTML 만들기 힘듬. 
	// RestTemplate 객체를 이용하면 쉽게 HTML을 전송 할 수도 있음.
}







