package com.my_library.entities;

import java.util.Date;

import com.my_library.Enum.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long iduser;
	
	@NotEmpty(message = "name est obligatoire")
    @Column(name = "Name")
	private String name;
	
	@NotEmpty(message = "subname est obligatoire")
    @Column(name = "subName")
	private String subname;
	
	@NotEmpty(message = "Email est obligatoire")
	@Email(message = "Email invalide")
    @Column(name = "email", unique = true)
	private String email;
	
	@NotEmpty(message = "date dd'inscription est obligatoire")
    @Column(name = "date d'inscription")
	private Date dateinscription;
	
	@NotEmpty(message = "mot de passe est obligatoire")
    @Column(name = "mot de passe")
	private String pwd;
	
	@NotEmpty(message = "Le rôle est obligatoire")
    @Column(name = "role")
	@Enumerated(EnumType.STRING)
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
