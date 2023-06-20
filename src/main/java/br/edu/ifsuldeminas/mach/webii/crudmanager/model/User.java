package br.edu.ifsuldeminas.mach.webii.crudmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class User {

	@Id // chave primaria da nossa tabela
	@GeneratedValue(strategy = GenerationType.AUTO) // gerar uma chave auto incremento
	private Integer id;
	private String name;
	private String email;
	private String gender;

	public User () {
		setName("");
		setEmail("");
		setGender("");
	}

	public User (Integer id) {
		this.id = id;
		setName("");
		setEmail("");
		setGender("");
	} // criar os obj vazios 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
}
