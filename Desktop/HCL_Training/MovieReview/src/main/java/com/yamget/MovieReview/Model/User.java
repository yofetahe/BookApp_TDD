package com.yamget.MovieReview.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	@Column
	@Length(min=4, message = " * Your full name must be at least 4 characters. ")
	@NotEmpty(message = " * Please provide your full name. ")
	private String full_name;
	
	@Column
	@Email(message = " * Please provide a valid Email.")
	@NotEmpty(message = " * Please provide your email. ")
	private String email;
	
	@Column
	@Length(min = 8, message = " * Your password must at least have 8 characters. ")
	@NotEmpty(message = " * Please provide your password. ")
	private String password;
	
	@Transient
	private String confirm_password;
	
	public User() {}

	public User(int user_id, String full_name, String email, String password) {
		super();
		this.user_id = user_id;
		this.full_name = full_name;
		this.email = email;
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
}
