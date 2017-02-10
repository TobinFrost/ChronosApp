package com.chronos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.JoinColumn;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;





@Entity
@Cacheable(false)
@NamedQueries({ 
	@NamedQuery(name = "listAllEmployee", query = "select e FROM Employee e"), 
	@NamedQuery(name = "EmployeeByMatricule", query = "select e FROM Employee e where e.matricule = :matricule") 
})
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8652665425276612310L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



	private String nom;
	private String prenom;
	private String matricule;
	private String statusPointage=Pointage.POINTAGE_STATUS_ABSENT;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "service_id", referencedColumnName = "id")
	private Service service; 

	@ManyToMany(mappedBy = "employees")
	private Set<Pointage> pointages = new HashSet<Pointage>(0);
	
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	
	
	
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "nom : "+this.nom+" | prenom : "+this.prenom;
}
/**
 * @return the statusPointage
 */
public String getStatusPointage() {
	return statusPointage;
}
/**
 * @param statusPointage the statusPointage to set
 */
public void setStatusPointage(String statusPointage) {
	this.statusPointage = statusPointage;
}
/**
 * @return the matricule
 */
public String getMatricule() {
	return matricule;
}
/**
 * @param matricule the matricule to set
 */
public void setMatricule(String matricule) {
	this.matricule = matricule;
}
}
