package org.itbank.app.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itbank.app.model.ProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/my")
public class ProfileController {
	
	@Autowired
	ProfileDao profileDao;
	
	@Autowired
	ServletContext application;
	
	@Autowired
	SimpleDateFormat sdf;
	
	@GetMapping("/profile")
	public ModelAndView profileHandle() {
		ModelAndView mav = new ModelAndView("t_info");
		

		mav.addObject("section", "profile");
		return mav;
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/profile")
	public ModelAndView profilePostHandle(@RequestParam(name="profile") MultipartFile f, Map map, 
																			HttpSession session) 
					throws InterruptedException {
		System.out.println(application.getRealPath("/profiles"));
		String id = (String)((Map)session.getAttribute("auth")).get("ID");
		String fmt = sdf.format(System.currentTimeMillis());
		String fileName = id+"_"+fmt;
		File dst = new File(application.getRealPath("/profiles"), fileName);
		boolean rst = profileDao.addOne(map);
		try {
			f.transferTo(dst);
			rst = !rst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("redirect:profile");
		mav.addObject("rst", rst);
		return mav;
	}
}