package com.icia.kty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class main_controller {
	
	// 기본페이지 1
				@RequestMapping(value = "/", method = RequestMethod.GET)
				public String index() {	
					return "index";
				}

}
