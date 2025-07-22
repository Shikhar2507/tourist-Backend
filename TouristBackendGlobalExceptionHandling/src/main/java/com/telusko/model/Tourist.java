package com.telusko.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tourist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String city;
	
	private String packagtype;
	
	private Double budget;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPackagtype() {
		return packagtype;
	}

	public void setPackagtype(String packagtype) {
		this.packagtype = packagtype;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Tourist(String name, String city, String packagtype, Double budget) {
		super();
		this.name = name;
		this.city = city;
		this.packagtype = packagtype;
		this.budget = budget;
	}

	public Tourist() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "tourist [id=" + id + ", name=" + name + ", city=" + city + ", packagtype=" + packagtype + ", budget="
				+ budget + "]";
	}
	
	

}
