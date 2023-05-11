package com.pcsgpl.tc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_user_profile")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name ="user_id")
	private String userID;
	
	@Column(name ="user_call_name")
	private String userCallName;
	
	@Column(name ="user_role_id")
	private String userRoleID;
	
	@Column(name = "user_role")
	private String userRole;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserCallName() {
		return userCallName;
	}

	public void setUserCallName(String userCallName) {
		this.userCallName = userCallName;
	}

	public String getUserRoleID() {
		return userRoleID;
	}

	public void setUserRoleID(String userRoleID) {
		this.userRoleID = userRoleID;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", userID="
				+ userID + ", userCallName=" + userCallName + ", userRoleID=" + userRoleID + ", userRole=" + userRole
				+ "]";
	}
	
	
	

}
