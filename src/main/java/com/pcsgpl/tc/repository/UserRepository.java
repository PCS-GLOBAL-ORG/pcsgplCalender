package com.pcsgpl.tc.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pcsgpl.tc.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
	UserEntity findByUserName(String userName);

}
