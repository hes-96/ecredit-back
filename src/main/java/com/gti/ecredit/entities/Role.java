package com.gti.ecredit.entities;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;

	public Role() {

	}

	public Role(String name) {
		this.name = name;
	}

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
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) {
	    	System.out.println("statement1");
	    	return false;
	    	}
	    Role role = (Role) obj;
	    System.out.println("statement2");
	    return Objects.equals(name, role.name);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(name);
	}

}