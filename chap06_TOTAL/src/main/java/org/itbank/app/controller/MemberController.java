package org.itbank.app.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
