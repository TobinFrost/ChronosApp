package com.chronos.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;






@Table(uniqueConstraints={
	       @UniqueConstraint(name="unique_date_service", columnNames={"service_id,datepointage"})
	   })
@Entity
@NamedQueries({
		
	@NamedQuery(name = "currentPointage", query = "SELECT p FROM Pointage p where p.datePointage = :currentDate and p.service = :service"),
		
	@NamedQuery(name = "currentPointageByDate", query = "SELECT p FROM Pointage p where p.datePointage = :currentDate"),
	@NamedQuery(name = "listAllPointage", query = "SELECT p FROM Pointage p") 
})
public class Pointage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8520593192391055025L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}
	@Temporal(TemporalType.DATE)
	
	private Date datePointage;
	
	
	
	private Service service;
	public static final String POINTAGE_STATUS_RETARD = "Retard";
	public static final String POINTAGE_STATUS_ABSENT = "Absent";
	public static final String POINTAGE_STATUS_PRESENT = "Present";
	public static final String POINTAGE_STATUS_PAUSE = "Pause";
	@JoinTable(joinColumns = @JoinColumn(name = "Pointage_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "employees_id", referencedColumnName = "id"))
	@ManyToMany
	private Set<Employee> employees = new HashSet<Employee>(0)  ;
	public Pointage() {
		// TODO Auto-generated constructor stub
		datePointage = Calendar.getInstance().getTime();
	}
	/**
	 * @return the datePointage
	 */
	public Date getDatePointage() {
		return datePointage;
	}
	/**
	 * @param datePointage the datePointage to set
	 */
	public void setDatePointage(Date datePointage) {
		this.datePointage = datePointage;
	}
	
	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
	}
	/**
	 * @return the employees
	 */
	public Set<Employee> getEmployees() {
		return employees;
	}
	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
