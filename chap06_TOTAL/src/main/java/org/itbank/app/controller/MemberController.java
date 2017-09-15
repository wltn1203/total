package org.itbank.app.controller;

import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.itbank.app.model.DetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/my")
public class MemberController {
	@Autowired
	DetailDao detailDao;
	
	@Autowired
	ServletContext application;
	
	@Autowired
	SimpleDateFormat sdf;
	
	@GetMapping("/profile")
	public ModelAndView profileHandle() {
		ModelAndView mav = new ModelAndView("t_info");
		String fmt = sdf.format(System.currentTimeMillis());
		System.out.println(fmt);
				
		mav.addObject("section", "profile");
		return mav;
	}
	
	@PostMapping("/profile")
	public ModelAndView profilePostHandle(@RequestParam Map param,
			@RequestParam(name="profile") MultipartFile f) 
					throws Exception {
		
		System.out.println(application.getRealPath("/temp"));
		Thread.sleep(10000);
		ModelAndView mav = new ModelAndView("t_info");
		System.out.println("파일정보====================");
		System.out.println(f.toString());
		System.out.println(f.isEmpty());
		System.out.println(f.getContentType());
		System.out.println(f.getName());
		System.out.println(f.getOriginalFilename());
		System.out.println(f.getSize());
		// transferTo(File f) .. 실제 업로드. getInputStream()
		
		System.out.println("profilePostHandle.."+param);
		mav.addObject("section", "profile");
		return mav;
	}
	
	
	@GetMapping("/info")
	public String GetHandle(Map map) {
		map.put("section", "info");
		return "t_info";
	}
	@PostMapping("/info")
	public String PostHandle(@RequestParam Map map) {
		int one = detailDao.Upinfo(map);
		map.put("one", one);
		map.put("section", "info");
		return "t_info";
	}
	
}
