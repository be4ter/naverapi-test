package kr.playground.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	private String state;
	private String code;
	@GetMapping("/request")
	public String loginPage() {
		String clientId = "qXqHpMUmMQgSY8abI1g6";// 애플리케이션 클라이언트 아이디값";
		String redirectURI = "";
		try {
			redirectURI = URLEncoder.encode("http://13.209.50.22:8080/callback",
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "redirect:/";
		}
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();
		return String.format(
				"redirect:https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=%s&redirect_uri=%s&state=%s",
				clientId, redirectURI, state);
	}
	@GetMapping("/callback")
	public String callbackResult(String code, String state) {
		this.code = code;
		this.state = state;
		return "index";
	}
}
