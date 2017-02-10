package com.chronos.managedBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.chronos.model.Employee;
import com.chronos.model.Service;

public class ManagedServiceBean {

	public ManagedServiceBean() {
		// TODO Auto-generated constructor stub
	}

	public Service createNewService(Service s){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				em.getTransaction().begin();
				em.persist(s);
				em.getTransaction().commit();
				return s;
		} finally {
			em.close();
		}
	}
	
	
	
	public Service getServiceById(int id){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				
				return (Service) em.find(Service.class, id);
				
		} finally {
			em.close();
		}
		
		
	}
	
	public Service alterService(Service s){
		
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				em.getTransaction().begin();
				 	Service se = em.find(Service.class, s.getId());
				 	se.setDescription(s.getDescription());
				 	se.setLead(s.getLead());
				 	se.setNom(s.getNom());
				 em.getTransaction().commit();
				 
				 return se;
				
		} finally {
			em.close();
		}
	}
	
	public void deleteService(int id){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			Service  s =em.find(Service.class, id);
			em.remove(s);
			em.getTransaction().commit();
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}
	
	
	// Cette Methode n'est pas bonne
	// Faut voir cote ManagedEmployeeBean
	public Set<Employee> addEmployee(Employee e, int id){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				em.getTransaction().begin();
				 Service s = em.find(Service.class, id);
				 	//Employee emp  = em.find(Employee.class, e.getId());
				 	//emp.setService(s);
				 	Set<Employee> temp = s.getEmployees();
				 	temp.add(e);
				 	s.setEmployees(temp);
				 em.getTransaction().commit();
				 
				 return s.getEmployees();
				
		} finally {
			em.close();
		}
	}
	
	public List<Service> ListService(){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				Query q = em.createNamedQuery("AllService", Service.class);
				return q.getResultList();
				
		} finally {
			em.close();
		}
	}
	
		public static void main(String[] args) {
			ManagedServiceBean sb = new ManagedServiceBean();
			ManagedEmployeeBean se = new ManagedEmployeeBean();
			Employee lead = se.getEmployeById(4);
			
			Service s = new Service();
			String description ="Service de Paquetage";
			s.setDescription(description);
			s.setNom("Paquetage");
			s.setLead(lead);
			//List<Employee> employees = new ArrayList<Employee>();
			//employees.add(lead);
			//s.getEmployees().add(lead);
			
			//sb.createNewService(s);
			
			s = sb.getServiceById(3);
			
			//employees = ;
			Employee e1 = se.getAllEmployee().get(1);
			
			System.out.println(e1);
			System.out.println(s.getEmployees().size());
			//System.out.println(sb.ListService().get(0).getEmployees().size());
			
		}
	
	
	
}
