package com.chronos.Bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.chronos.managedBean.ManagedEmployeeBean;
import com.chronos.managedBean.ManagedPermissionBean;
import com.chronos.model.Employee;
import com.chronos.model.Permission;

@ManagedBean(name="permissionBean")
@ViewScoped
public class PermissionBean {

	private ManagedPermissionBean managedpermission = new ManagedPermissionBean();
	private ManagedEmployeeBean managedEmployee = new ManagedEmployeeBean();
	private Permission newPermission = new Permission();
	private int idEmployeeToSet = -1;
	public PermissionBean() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the managedpermission
	 */
	public ManagedPermissionBean getManagedpermission() {
		return managedpermission;
	}
	
	public void createNewPermission(){
		if(idEmployeeToSet != 1 || (newPermission.getDebutPermission() != null) || (newPermission.getFinpermission() != null) || (newPermission.getTypePermission().equals("")) ){
			Employee e = managedEmployee.getEmployeById(idEmployeeToSet);
			newPermission.setEmployee(e);
			managedpermission.createNewPermission(newPermission);
			idEmployeeToSet = -1;
		}
		
	}
	
	public void decide(int id,boolean ac){
			managedpermission.alterPermissionAutorization(id, ac);
	}
	
	public List<Employee> getEmployees(){
		return managedEmployee.getAllEmployee();
	}
	
	public List<Permission> getPermissions(){
		return managedpermission.allPermission();
	}
	
	public List<Permission> getNotAccordedPermissions(){
		return managedpermission.allNotAccordedPermission();
	}
	
	/**
	 * @param managedpermission the managedpermission to set
	 */
	public void setManagedpermission(ManagedPermissionBean managedpermission) {
		this.managedpermission = managedpermission;
	}
	/**
	 * @return the newPermission
	 */
	public Permission getNewPermission() {
		return newPermission;
	}
	/**
	 * @param newPermission the newPermission to set
	 */
	public void setNewPermission(Permission newPermission) {
		this.newPermission = newPermission;
	}
	/**
	 * @return the managedEmployee
	 */
	public ManagedEmployeeBean getManagedEmployee() {
		return managedEmployee;
	}
	/**
	 * @param managedEmployee the managedEmployee to set
	 */
	public void setManagedEmployee(ManagedEmployeeBean managedEmployee) {
		this.managedEmployee = managedEmployee;
	}
	/**
	 * @return the idEmployeeToSet
	 */
	public int getIdEmployeeToSet() {
		return idEmployeeToSet;
	}
	/**
	 * @param idEmployeeToSet the idEmployeeToSet to set
	 */
	public void setIdEmployeeToSet(int idEmployeeToSet) {
		this.idEmployeeToSet = idEmployeeToSet;
	}

}
