package com.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examen.entity.AuthenticationRequest;
import com.examen.entity.AuthenticationResponse;
import com.examen.entity.UpdatePasswordRequest;
import com.examen.service.MyUserDetailService;
import com.examen.service.UsuarioService;
import com.examen.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailService userDerailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private UsuarioService usuarioService;
 	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthrnticationToken(@RequestBody AuthenticationRequest aunthenticationRequest) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(aunthenticationRequest.getUsername(),aunthenticationRequest.getPassword()));
		}catch(BadCredentialsException bce){
			return ResponseEntity.badRequest().body("Usuario o password Incorretos");
		}catch(CredentialsExpiredException t) {
			final UserDetails userDetails = userDerailsService.loadUserByUsername(aunthenticationRequest.getUsername());
			final String jwt = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new AuthenticationResponse(jwt,true));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario o password Incorretos");
		}
		
		final UserDetails userDetails = userDerailsService.loadUserByUsername(aunthenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt,false));
	}
	
	@RequestMapping(value = "/reset", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest){
		int respuesta = usuarioService.updatePassword(updatePasswordRequest);
		if(respuesta ==1 ) {
			return ResponseEntity.ok(new ResponseUpdate("true"));
		}else {
			return ResponseEntity.internalServerError().body(new ResponseUpdate("fail"));
		}
		
	}
	
	public static class ResponseUpdate {
		private String status;
		

		public ResponseUpdate(String status) {
			super();
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		
	}
}
