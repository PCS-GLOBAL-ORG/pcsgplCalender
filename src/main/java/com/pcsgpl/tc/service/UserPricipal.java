package com.pcsgpl.tc.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pcsgpl.tc.entity.UserEntity;


public class UserPricipal implements UserDetails{
	
	@Autowired
	UserEntity userEntity;
	
	public UserPricipal(UserEntity userEntity) {
	super();
	this.userEntity = userEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		GrantedAuthority auth = new GrantedAuthority() {

			@Override
			public String getAuthority() {
				// TODO Auto-generated method stub
				return userEntity.getUserRole();
			}
			
		};
		
		return List.of(auth);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userEntity.getUserPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userEntity.getUserID();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}




