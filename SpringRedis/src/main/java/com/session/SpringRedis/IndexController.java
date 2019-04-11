package com.session.SpringRedis;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class IndexController {

	// @Autowired
	// private RedisOperations<String, Object> redisOps;

	@Autowired
	private SessionRepository sessionRepo;

	private AuthenticationManager authenticationManager;

	IndexController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@GetMapping
	// @Secured("ROLE_ADMIN")
	@PreAuthorize("hasRole('ROLE_DMIN')")
	ResponseEntity index(HttpServletRequest request, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println("authority .." + grantedAuthority.getAuthority());
		}
		return new ResponseEntity<>(authentication.getName(), HttpStatus.OK);
	}

	@Scheduled(fixedRate = 2000)
	public void getDetails() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		/*
		 * Set<String> keys = redisOps.keys("spring:session" + "*");
		 * 
		 * System.out.println("active sessions.." + keys.size());
		 * 
		 * for (String key : keys) { String id =
		 * key.substring("spring:session".length());
		 * 
		 * Session session = sessionRepo.getSession(id);
		 * 
		 * if (session != null) { Date date = new Date(((HttpSession)
		 * session).getLastAccessedTime()); System.out.println("Session " + id +
		 * " last accessed: " + date.toString()); } }
		 */

	}

	@PostMapping("/login")
	ResponseEntity login(@RequestBody LoginRequest loginRequest) {
		String username = loginRequest.getUserName();
		String password = loginRequest.getPassWord();

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		Authentication authentication = this.authenticationManager.authenticate(token);
		// vvv THIS vvv
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<>(authentication.getPrincipal(), HttpStatus.OK);
	}
}