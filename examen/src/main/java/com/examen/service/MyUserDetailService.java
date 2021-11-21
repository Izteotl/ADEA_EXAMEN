package com.examen.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.examen.entity.MyUserDetails;
import com.examen.entity.Usuario;
import com.examen.repository.UserRepository;


@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> user =  userRepository.findById(username);
		return new MyUserDetails(user.get());
		//return user.map(MyUserDetails::new).get();
	}

}
