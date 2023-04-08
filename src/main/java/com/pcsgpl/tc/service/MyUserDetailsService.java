package com.pcsgpl.tc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pcsgpl.tc.entity.UserEntity;
import com.pcsgpl.tc.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired 
	  private UserRepository repo;
        
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    	UserEntity userEntity = repo.findByUserName(username);
  	  if(userEntity==null) {
  		  throw new UsernameNotFoundException("User Not Found - 404");
  	  }
  	  
  	  UserDetails userDetails =  new UserPricipal(userEntity);
  	  
  	  
  	  return userDetails;
    }
	
}
