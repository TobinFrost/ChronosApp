package com.chronos.Bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.chronos.managedBean.ManagedEmployeeBean;
import com.chronos.managedBean.ManagedServiceBean;
import com.chronos.model.Employee;
import com.chronos.model.Service;

@ManagedBean(name="serviceBean")
@ViewScoped
public class ServiceBean {
	
	private List<Service> services;
	private  ManagedServiceBean managedService = new ManagedServiceBean();
	private ManagedEmployeeBean managedEmployee = new ManagedEmployeeBean();
	private Service selectedService;
	private Service newService = new Service();
	private int idEmployeeToSet = -1;

	public ServiceBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the services
	 */
	public List<Service> getServices() {
		if(services == null){
			services = managedService.ListService();
		}
		return services;
	}
	
	public List<Employee> getEmployees(){
		return managedEmployee.getAllEmployee();
	}

	/**
	 * @return the selectedService
	 */
	public Service getSelectedService() {
		return selectedService;
	}

	/**
	 * @param selectedService the selectedService to set
	 */
	public void setSelectedService(Service selectedService) {
		this.selectedService = selectedService;
	}
	
	public void onRowEdit(RowEditEvent event){
		if(idEmployeeToSet != -1){
			Service s = (Service) event.getObject();
			Employee e = managedEmployee.getEmployeById(idEmployeeToSet);
			s.setLead(e);
			managedService.alterService(s);
			
			idEmployeeToSet = -1;
		}
	}

	public void deleteService(int id){
		infoDeletion();
		System.out.println("Suppression : "+id);
		managedService.deleteService(id);
	}
	
	public String createNewService(){
		if(!(newService.getNom().equals("")) || !(newService.getDescription().equals("")) || (idEmployeeToSet != -1 )){
			Employee e = managedEmployee.getEmployeById(idEmployeeToSet);
			newService.setLead(e);
			managedService.createNewService(newService);
		}
		return "service";
	}
	
	public void infoDeletion() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Service supprimée avec succès"));
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

	/**
	 * @return the newService
	 */
	public Service getNewService() {
		return newService;
	}

	/**
	 * @param newService the newService to set
	 */
	public void setNewService(Service newService) {
		this.newService = newService;
	}

}
