package com.my_library.entities;

import java.util.Date;

import com.my_library.Enum.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long iduser;
	
	private String name;
	
	private String subname;
	
	private String email;
	
	private Date dateinscription;
	
	private String pwd;
	
	private Role role;
	
	//getters and setters 

	public long getIduser() {
		return iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateinscription() {
		return dateinscription;
	}

	public void setDateinscription(Date dateinscription) {
		this.dateinscription = dateinscription;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * 
	 */
	public User() {}

	/**
	 * @param iduser
	 * @param name
	 * @param subname
	 * @param email
	 * @param dateinscription
	 * @param pwd
	 * @param role
	 */
	public User(long iduser, String name, String subname, String email, Date dateinscription, String pwd, Role role) {
		super();
		this.iduser = iduser;
		this.name = name;
		this.subname = subname;
		this.email = email;
		this.dateinscription = dateinscription;
		this.pwd = pwd;
		this.role = role;
	}
	
	
	
	
	
	

}
