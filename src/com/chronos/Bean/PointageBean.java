package com.chronos.Bean;

import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.chronos.managedBean.ManagedEmployeeBean;
import com.chronos.managedBean.ManagedPointageBean;
import com.chronos.managedBean.ManagedPolicieBean;
import com.chronos.managedBean.ManagedServiceBean;
import com.chronos.model.Employee;
import com.chronos.model.HorairePolicie;
import com.chronos.model.Pointage;
import com.chronos.model.Service;

@ManagedBean(name="pointageBean")
@ViewScoped
public class PointageBean {
	private ManagedPointageBean managedPointage = new ManagedPointageBean();
	ManagedEmployeeBean managedEmployee = new ManagedEmployeeBean();
	ManagedServiceBean managedService = new ManagedServiceBean();
	ManagedPolicieBean managedPolicie = new ManagedPolicieBean();
	private Pointage newPointage = new Pointage();
	private Pointage currentPointage;
	private Service serviceToPointage;
	private int idServiceToPointage = -1;
	private String employeeMatricule;
	private int idServiceToPoint = -1;
	private int idResponsableToLog = -1;
	public PointageBean() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the newPointage
	 */
	public Pointage getNewPointage() {
		return newPointage;
	}
	/**
	 * @param newPointage the newPointage to set
	 */
	public void setNewPointage(Pointage newPointage) {
		this.newPointage = newPointage;
	}
	
	
	public List<Service> getServices(){
		return managedService.ListService();
	}
	
	public List<Employee> getEmployees(){
		return managedEmployee.getAllEmployee();
	}
	
	public void createNewPointage(){
		if(idServiceToPointage != -1){
			newPointage.setService(managedService.getServiceById(idServiceToPointage));
			managedPointage.createNewPointage(newPointage);
			idServiceToPointage = -1;
		}
		
	}
	
	
	public List<Pointage> getAllPointages(){
		return managedPointage.allPointage();
	}
	
	
	
	/**
	 * @return the currentPointage
	 */
	public Pointage getCurrentPointage() {
			currentPointage = managedPointage.getCurrentPointage(getServiceToPointage()); 
		return currentPointage;
	}
	/**
	 * @param currentPointage the currentPointage to set
	 */
	public void setCurrentPointage(Pointage currentPointage) {
		this.currentPointage = currentPointage;
	}
	/**
	 * @return the serviceToPointage
	 */
	public Service getServiceToPointage() {
		return serviceToPointage;
	}
	/**
	 * @param serviceToPointage the serviceToPointage to set
	 */
	public void setServiceToPointage(Service serviceToPointage) {
		this.serviceToPointage = serviceToPointage;
	}
	
	public void infoGood() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Employee Pointé avec succès"));
    }
	
	public void infoBad() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Employee Inconnu"));
    }
	
	public void infoBadPointage() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Le Pointage pour ce service est indisponible"));
    }
	
	public List<Pointage> getCurrentPointageByDate(){
		return managedPointage.getCurrentPointageByDate();
	}
	
	public void pointerEmployee(){
		if(idServiceToPoint != -1){
			Employee e = managedEmployee.getEmployeeByMatricule(employeeMatricule);
			HorairePolicie policie = managedPolicie.getPolicie();
			if(e != null){
				Service s = managedService.getServiceById(idServiceToPoint);
				Pointage p = managedPointage.getCurrentPointage(s);
				if(p != null){
					Calendar todayDate = Calendar.getInstance();
					int nowHour  = todayDate.get(Calendar.HOUR);
					int nowMinute = todayDate.get(Calendar.MINUTE);
					
					System.out.println("heure limit : "+ policie.getHeureLimitPointage() +"> = "+ nowHour);
					System.out.println("minute limit : "+ policie.getMinuteLimitPointage()+"> = "+ nowMinute);
					managedEmployee.alterEmployeeSetStatusPointage(e.getId(), policie.getHeureLimitPointage(), policie.getMinuteLimitPointage());
					managedPointage.alterPointageAddEmployee(e,s);
					infoGood();
				}else{
					infoBadPointage();
				}
			}else{
				infoBad();
			}
		}
		System.out.println("Matricule Employee : "+employeeMatricule);
		System.out.println("Id Service Employee : "+idServiceToPoint);
	}
	/**
	 * @return the employeeMatricule
	 */
	public String getEmployeeMatricule() {
		return employeeMatricule;
	}
	/**
	 * @param employeeMatricule the employeeMatricule to set
	 */
	public void setEmployeeMatricule(String employeeMatricule) {
		this.employeeMatricule = employeeMatricule;
	}
	/**
	 * @return the idServiceToPoint
	 */
	public int getIdServiceToPoint() {
		return idServiceToPoint;
	}
	/**
	 * @param idServiceToPoint the idServiceToPoint to set
	 */
	public void setIdServiceToPoint(int idServiceToPoint) {
		this.idServiceToPoint = idServiceToPoint;
	}
	/**
	 * @return the idServiceToPointage
	 */
	public int getIdServiceToPointage() {
		return idServiceToPointage;
	}
	/**
	 * @param idServiceToPointage the idServiceToPointage to set
	 */
	public void setIdServiceToPointage(int idServiceToPointage) {
		this.idServiceToPointage = idServiceToPointage;
	}
	/**
	 * @return the idResponsableToLog
	 */
	public int getIdResponsableToLog() {
		return idResponsableToLog;
	}
	/**
	 * @param idResponsableToLog the idResponsableToLog to set
	 */
	public void setIdResponsableToLog(int idResponsableToLog) {
		this.idResponsableToLog = idResponsableToLog;
	}

}
