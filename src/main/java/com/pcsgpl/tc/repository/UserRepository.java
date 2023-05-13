package com.pcsgpl.tc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pcsgpl.tc.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
	UserEntity findByUserID(String userID);
	
//	UserEntity findByUserName(String userName);
	//UserEntity find(String userRoleID);

}
