package org.itbank.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.itbank.app.model.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InfoController {
	@Autowired
	MemberDao memberDao;

	@RequestMapping("/info/mlist")
	public ModelAndView mlistHandle(@RequestParam(name = "page", defaultValue = "1") int page) {
		ModelAndView mav = new ModelAndView("t_expr");
		int tot = memberDao.countAll();
		int size = tot / 5 + (tot % 5 != 0 ? 1 : 0);
		mav.addObject("tot", tot);
		mav.addObject("size", size);
		mav.addObject("section", "info/memberlist");
		if(page>tot)
			page = tot;
		if(page <0) 
			page = 1;
		
		Map p = new HashMap();
		p.put("start", (page - 1) * 5 + 1); // (page-1)*5 +1
		p.put("end", page * 5); //

		mav.addObject("mlist", memberDao.readSome(p));

		return mav;
	}
}