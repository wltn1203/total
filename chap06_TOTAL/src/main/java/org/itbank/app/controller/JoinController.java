package org.itbank.app.controller;

import java.util.Map;
import java.util.UUID;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.itbank.app.controller.ws.AlertWSHandler;
import org.itbank.app.model.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JoinController {
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	JavaMailSender sender;

	@Autowired
	AlertWSHandler aws;	// 웹소켓 핸들러를 AutoWired 걸어서 연결 잡고.
	
	@GetMapping(path = "/join")
	public String joinGetHandle(Model model) {
		model.addAttribute("section", "join");
		return "t_expr";
	}  

	@RequestMapping("/join/auth")
	@ResponseBody
	public String joinAuthHandle(@RequestBody String target, HttpSession session) {
			UUID u = UUID.randomUUID();
			String auth_str = u.toString().substring(0, 13);
			session.setAttribute("auth_str", auth_str);
		try {
			MimeMessage msg = sender.createMimeMessage(); 
			// TO
			msg.setRecipient(RecipientType.TO, new InternetAddress(target));
			// SUBJECT
			msg.setSubject("[1st Story]인증번호");
			// TEXT
			String text = "<h3>#인증번호</h3>";
			text += "[1st Story 에서 보낸 인증번호 : "+auth_str+"입니다.]";
			text += "<a href=\"http://192.168.10.75\">사이트 이동</a>";
			msg.setText(text, "UTF-8", "html");
			sender.send(msg);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "true";	
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
