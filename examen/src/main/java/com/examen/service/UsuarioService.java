package com.examen.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.entity.UpdatePasswordRequest;
import com.examen.repository.UserRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UserRepository userRepository;
	
	public int updatePassword(UpdatePasswordRequest updatePasswordRequest) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		return userRepository.updatePasswordAndDate(updatePasswordRequest.getNewPassword(),calendar.getTime() , updatePasswordRequest.getUsername());
		
	}
}
