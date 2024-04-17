package com.blog.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public boolean getStatus() {
		return status;
	}
	public void setAbout(String about) {
		this.about = about;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 40 , nullable = false)
	private String name;
	
	@Column(length = 100 , nullable = false)
	private String email;
	
	@Column(length = 50, nullable = false)
	private String username;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	@Column(length = 1000, nullable = true)
	private String about;
	
	@Column(nullable = false )
	@Value("${some.key:true}")
	private boolean status;
	

	@OneToMany(mappedBy = "user" )
	private List<Post> post = new ArrayList();

}
