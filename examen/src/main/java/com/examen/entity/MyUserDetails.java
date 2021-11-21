package com.examen.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2650995814685500998L;
	private String userName;
	private String password;
	private boolean active;
	private boolean expired;
	private List<GrantedAuthority> authorities;

	public MyUserDetails(Usuario user) {
		this.userName = user.getLogin();
		this.password = user.getPassword();
		this.active   = true;
		this.expired  =	!isUserExpired(user.getFechaModificacion());
		this.authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		
	}
	
	private boolean isUserExpired(Date fechaModificacion) {
			Date date1 = fechaModificacion;
			Date date2 = new Date();
			if(date2.equals(date1) || date1.before(date2)) {
				return true;
			}
		return false;
	}

	public MyUserDetails() {
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return expired;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

	

}
