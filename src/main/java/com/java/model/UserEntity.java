package com.java.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.java.annotation.UniqueUsername;


@Entity
@Table(name="app_user")
public class UserEntity {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty
	@Size(min=5)
	@Column(unique=true)
	@UniqueUsername(message = "username already exists")
	private String name;
	
	@NotEmpty
	@Size(min=5)
	@Email
	private String email;
	
	@NotEmpty
	@Size(min=5)
	private String password;
	private boolean enabled;
	
	@ManyToMany
	@JoinTable
	private List<Role>roles;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE)
	private List<Blog>blog;
	
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		this.password = encoder.encode(password);
		}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Blog> getBlog() {
		return blog;
	}
	public void setBlog(List<Blog> blog) {
		this.blog = blog;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
