package com.chronos.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

import com.chronos.managedBean.ManagedEmployeeBean;
import com.chronos.managedBean.ManagedServiceBean;
import com.chronos.model.Employee;
import com.chronos.model.Service;

@ManagedBean(name="employeeBean")
@ViewScoped
public class EmployeeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1166068555931411267L;
	private List<Employee> employees;
	private ManagedEmployeeBean employeemanaged = new ManagedEmployeeBean();
	private ManagedServiceBean servicemanaged = new ManagedServiceBean();
	private Employee selectedEmployee;
	private Employee newEmployee = new Employee();
	private int idServiceToSet=-1;
	
	public EmployeeBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the employees
	 */
	
	public List<Employee> getEmployees() {
		if(employees == null){
			employees = employeemanaged.getAllEmployee();
		}
		return employees;
	}
	@PostConstruct
	public void init(){
		getEmployees();
	}

	/**
	 * @return the selectedEmployee
	 */
	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	/**
	 * @param selectedEmployee the selectedEmployee to set
	 */
	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	public List<Service> getServices(){
		return servicemanaged.ListService();
	}
	
	public void onRowEdit(RowEditEvent event){
		System.out.println("ID Employee : "+((Employee) event.getObject()).getId());
		System.out.println("ID Service Employee : "+(idServiceToSet));
		int employeeId = ((Employee) event.getObject()).getId();
		Employee e = (Employee) event.getObject();
		System.out.println(e.toString());
		if(idServiceToSet != -1){
			Service s = servicemanaged.getServiceById(idServiceToSet);
			employeemanaged.alterEmployeeSetService(employeeId, s);
			employeemanaged.alterEmployee(employeeId,e);
			init();
			idServiceToSet = -1;
			System.out.println("Altered -1 ");
		}
		
	}
	
	
/*	public void onRowEdit(RowEditEvent event){
		System.out.println("ID Employee : "+((Employee) event.getObject()).getId());
		//System.out.println("ID Service Employee : "+(idServiceToSet));
		Employee e = (Employee) event.getObject();
		int employeeId = e.getId();
		employeemanaged.alterEmployee(employeeId,e);
		init();
		//idServiceToSet = -1;
		
	}
*/	
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public String createNewEmployee(){
		if(!(newEmployee.getNom().equals("")) || !(newEmployee.getPrenom().equals(""))){
			employeemanaged.createNewEmployee(newEmployee);
			//addMessage("Employee "+newEmployee.getNom()+" crée");
			info();
			newEmployee = new Employee();
		}
		
		return "employee";
	}
	
	public void deleteEmployee(int id){
		employeemanaged.deleteEmployee(id);
	}

	public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Employee créé avec succès"));
    }
	
	/**
	 * @return the idServiceToSet
	 */
	public int getIdServiceToSet() {
		return idServiceToSet;
	}

	/**
	 * @param idServiceToSet the idServiceToSet to set
	 */
	public void setIdServiceToSet(int idServiceToSet) {
		this.idServiceToSet = idServiceToSet;
	}

	/**
	 * @return the newEmployee
	 */
	public Employee getNewEmployee() {
		return newEmployee;
	}

	/**
	 * @param newEmployee the newEmployee to set
	 */
	public void setNewEmployee(Employee newEmployee) {
		this.newEmployee = newEmployee;
	}
	
	
}
