package com.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.entity.Usuario;
import com.examen.repository.UserRepository;

@RestController
public class HomeResource {
 
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public String home() {
		Usuario usuario = new Usuario();
		usuario.setLogin("izte");
		usuario.setPassword("123");
		userRepository.save(usuario);
		return ("<h1>Welcome</h1>");
	}
	@GetMapping("/user")
	public String user() {
		return ("<h1>Welcome User</h1>");
	}
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Welcome Admin</h1>");
	}
}
