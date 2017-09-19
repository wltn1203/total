package org.itbank.app.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.itbank.app.controller.ws.AlertWSHandler;
import org.itbank.app.model.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {
	@Autowired
	MemberDao memberDao;

	@Autowired
	AlertWSHandler aws; // 웹소켓 핸들러를 Autowired 걸어서 연결 잡고.
	
	@GetMapping(path = "/join")
	public String joinGetHandle(Model model) {
		model.addAttribute("section", "join");
		return "t_expr";
	}  

	@PostMapping("/join")
	public String joinPostHandle(@RequestParam Map map, HttpSession session, Model model) {
		try {
			boolean b = memberDao.addOne(map);
			
			session.setAttribute("auth", map);
			session.setAttribute("auth_id", map.get("id"));
			
			/*
			 * AlertWSHandler를 통해서, 메세지를 보내보자. 
			 */
			aws.sendMessage("누군가 가입하였습니다"); 
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("temp", map);
			model.addAttribute("section", "join");
			return "t_expr";
		}
	}

	@PostMapping("/signup_check/{mode}")
	public String signupHandle() {
		return "";
	}
}
