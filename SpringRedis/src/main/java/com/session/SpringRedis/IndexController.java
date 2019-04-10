package com.session.SpringRedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class IndexController {

	private AuthenticationManager authenticationManager;

	IndexController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@GetMapping
	ResponseEntity index(HttpServletRequest request, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return new ResponseEntity<>(authentication.getPrincipal(), HttpStatus.OK);
	}

	@PostMapping("/login")
	ResponseEntity login(@RequestBody LoginRequest loginRequest) {
		String username = loginRequest.getUserName();
		String password = loginRequest.getPassWord();
		
		 UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		    Authentication authentication = this.authenticationManager.authenticate(token);
		    // vvv THIS vvv
		    SecurityContextHolder
		        .getContext()
		        .setAuthentication(authentication);
		return new ResponseEntity<>(authentication.getPrincipal(), HttpStatus.OK);
	}
}