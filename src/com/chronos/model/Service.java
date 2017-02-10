package com.chronos.model;


import java.util.HashSet;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import static javax.persistence.CascadeType.ALL;
import javax.persistence.NamedQuery;



@Entity
@NamedQuery(name = "AllService", query = "SELECT s FROM Service s ")
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String description;
	@OneToOne	
	private Employee lead;
	
	
	@OneToMany(cascade = ALL, mappedBy = "service")
	private Set<Employee> employees = new HashSet<Employee>(0)  ;

	public Service() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the employees
	 */
	
	

	/**
	 * @param employees the employees to set
	 */
	

	/**
	 * @return the lead
	 */
	public Employee getLead() {
		return lead;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * @param lead the lead to set
	 */
	public void setLead(Employee lead) {
		this.lead = lead;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
