package com.pcsgpl.tc.service;

import java.util.List;

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
   
	@Override
    public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException{
		System.out.println("user id" +userID);
    	UserEntity userEntity = repo.findByUserID(userID); 
    	
		//UserEntity userEntity1 = repo.findByUserID(userRoleID);
  	  if(userEntity==null) {
  		  throw new UsernameNotFoundException("User Not Found - 404");
  	  }
  	  
  	  UserDetails userDetails =  new UserPricipal(userEntity);
  	  System.out.println("User Id :"+userDetails.getUsername());
  	  
  	  userDetails.getAuthorities().forEach(auth -> {
  		 System.out.print(auth.getAuthority());
  	  });
  	  
  	 
  	
  	  return userDetails;
    }
     
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
//    	UserEntity userEntity = repo.findByUserName(userName);
//		//UserEntity userEntity1 = repo.findByUserID(userRoleID);
//  	  if(userEntity==null) {
//  		  throw new UsernameNotFoundException("User Not Found - 404");
//  	  }
//  	  
//  	  UserDetails userDetails =  new UserPricipal(userEntity);
//  	  System.out.println("User Name :"+userName);
//  	  
//  	  userDetails.getAuthorities().forEach(auth -> {
//  		 System.out.print(auth.getAuthority());
//  	  });
//  	  
//  	 
//  	
//  	  return userDetails;
//    }

	

	
}
