package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Manager {
	
	private int id;
	private String name;
	private String pwd;
	public Manager() {
	}
	
	public Manager(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

	
	public Manager(int id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	@Column
	public String getName() {
		return name;
	}

	@Column
	public String getPwd() {
		return pwd;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
	
	

}
