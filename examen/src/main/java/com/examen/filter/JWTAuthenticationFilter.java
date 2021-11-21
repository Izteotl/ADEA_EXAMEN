package com.examen.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.examen.entity.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	public Authentication attempAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
		try {
			System.out.println("attempAuthentication");
			Usuario creds = new ObjectMapper().readValue(req.getInputStream(), Usuario.class);
			Authentication am = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							creds.getLogin(),
							creds.getPassword(),
							new ArrayList<>()
							)
					);
			return am;
		}catch(IOException e) {
			System.out.println("trueno aqui");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth ) throws JsonProcessingException, IOException {
		Map<String,Object> body = new HashMap<String,Object>();
		body.put("exito", "Succes");
		res.setStatus(200);
		res.getWriter().write(new ObjectMapper().writeValueAsString(body));
		res.setContentType("application/json");
	}
}
