package org.itbank.app.controller;

import java.util.Map;

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
	@PostMapping("/info/{id}")
	public String PostHandle(@PathVariable String id, Map map) {
		Map one = detailDao.Getinfo(id);
		map.put("one", one);
		map.put("section", "my/info");
		return "t_info";
	}
	
}
