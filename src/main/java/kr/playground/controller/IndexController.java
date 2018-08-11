package kr.playground.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	private static final Logger log = LoggerFactory
			.getLogger(IndexController.class);

	private String code;
	private String state;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/callback")
	public String callback(String code, String state) {
		this.code = code;
		this.state = state;
		log.info("code : " + code);
		log.info("state : " + state);
		return "redirect:/";
	}
}
