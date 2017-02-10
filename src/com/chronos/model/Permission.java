package com.chronos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({
		
	@NamedQuery(name = "PermissionNotAccorded", query = "SELECT p FROM Permission p WHERE p.employee = :employee and p.accorded = false  "),
		
	@NamedQuery(name = "allPermissions", query = "SELECT p FROM Permission p"),
	@NamedQuery(name = "listNotAccorded", query = "SELECT p FROM Permission p WHERE p.accorded = false") 
})
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private Employee employee;
	public static final String TypePermission_RTT = "Congé"; // Reduction Temps  de Travail
	public static final String TypePermission_FORMATION="Seminaire";
	@Temporal(TemporalType.DATE)
	private Date debutPermission;
	@Temporal(TemporalType.DATE)
	private Date finpermission;
	private Boolean accorded=false;
	private String typePermission;
	public Permission() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the debutPermission
	 */
	public Date getDebutPermission() {
		return debutPermission;
	}

	/**
	 * @param debutPermission the debutPermission to set
	 */
	public void setDebutPermission(Date debutPermission) {
		this.debutPermission = debutPermission;
	}

	/**
	 * @return the finpermission
	 */
	public Date getFinpermission() {
		return finpermission;
	}

	/**
	 * @param finpermission the finpermission to set
	 */
	public void setFinpermission(Date finpermission) {
		this.finpermission = finpermission;
	}

	/**
	 * @return the accorded
	 */
	public Boolean getAccorded() {
		return accorded;
	}

	/**
	 * @param accorded the accorded to set
	 */
	public void setAccorded(Boolean accorded) {
		this.accorded = accorded;
	}

	/**
	 * @return the typePermission
	 */
	public String getTypePermission() {
		return typePermission;
	}

	/**
	 * @param typePermission the typePermission to set
	 */
	public void setTypePermission(String typePermission) {
		this.typePermission = typePermission;
	}

}
