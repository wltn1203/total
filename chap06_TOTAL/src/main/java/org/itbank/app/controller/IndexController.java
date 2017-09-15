package org.itbank.app.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.itbank.app.model.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
	@Autowired
	MemberDao memberDao;

	@RequestMapping({ "/", "/index" })
	public ModelAndView rootHandle() {
		ModelAndView mav = new ModelAndView("t_expr");
			mav.addObject("section", "index");
		return mav;
	}
	@RequestMapping("/login")
	public String loginHandle(Map map) {
		map.put("section", "login");
		return "t_expr";
	}

	@RequestMapping("/session")
	public String sessionHandle(@RequestParam Map param, Model model, HttpSession session) throws SQLException {
		HashMap t = memberDao.readOne(param);
		if (t != null) {
			session.setAttribute("auth", t);
			return "redirect:/";
		} else {
			model.addAttribute("temp", param);
			model.addAttribute("section", "login");
			return "t_expr";
		}
	}
	
	
} 
