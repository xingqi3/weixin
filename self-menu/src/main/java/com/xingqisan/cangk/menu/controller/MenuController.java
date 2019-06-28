package com.xingqisan.cangk.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xingqisan.cangk.menu.domain.Menu;

@Controller
@RequestMapping("/kemao_1_menu/menu")
public class MenuController {

	@GetMapping
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/views/self/menu/index.jsp");
		return mav;
	}

	@GetMapping(produces = "application/json")
	@ResponseBody
	public Menu data() {
		return null;
	}

	@PostMapping
	@ResponseBody
	public String save(@RequestBody Menu menu) {
		return "保存成功";
	}
}