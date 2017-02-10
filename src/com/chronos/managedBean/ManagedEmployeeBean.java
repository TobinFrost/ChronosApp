package com.chronos.managedBean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.chronos.model.Employee;

import com.chronos.model.Pointage;
import com.chronos.model.Service;

public class ManagedEmployeeBean {

	public ManagedEmployeeBean() {
		// TODO Auto-generated constructor stub
	}

	public Employee createNewEmployee(Employee e){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				em.getTransaction().begin();
				em.persist(e);
				em.getTransaction().commit();
				return e;
		} finally {
			em.close();
		}
	}
	
	public Employee getEmployeeByMatricule(String matricule){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
			Query  q = em.createNamedQuery("EmployeeByMatricule");
			q.setParameter("matricule", matricule);
			return (Employee) q.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}finally {
			// TODO: handle finally clause
			em.close();
		}
		
	}
	
	public Employee getEmployeById(int id){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				return em.find(Employee.class, id);
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}
	
	public List<Employee> getAllEmployee(){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
			Query  q = em.createNamedQuery("listAllEmployee");
			return q.getResultList();
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}
	
	public Employee alterEmployeeSetService(int id,Service s){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				em.getTransaction().begin();
					Employee e = em.find(Employee.class, id);
					e.setService(s);
				em.getTransaction().commit();
				return e;
			
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}
	
	public Employee alterEmployee(int id,Employee s){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				em.getTransaction().begin();
					Employee e = em.find(Employee.class, id);
					e.setNom(s.getNom());
					e.setPrenom(s.getPrenom());
					
				em.getTransaction().commit();
				return e;
			
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}
	
	public Employee alterEmployeeSetStatusPointage(int id,int heureLimitPointage,int minuteLimitPointage){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		Calendar todayDate = Calendar.getInstance();
		Calendar policie = Calendar.getInstance();
		 
		policie.set(Calendar.HOUR,heureLimitPointage);
		policie.set(Calendar.MINUTE,minuteLimitPointage);
		
		try {
				em.getTransaction().begin();
					Employee e = em.find(Employee.class, id);
					if(todayDate.before(policie)){
						
						e.setStatusPointage(Pointage.POINTAGE_STATUS_PRESENT);
						
					}else{
						e.setStatusPointage(Pointage.POINTAGE_STATUS_RETARD);
					}
				em.getTransaction().commit();
				return e;
			
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	} 
	
	public void deleteEmployee(int id){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			Employee  p =em.find(Employee.class, id);
			em.remove(p);
			em.getTransaction().commit();
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}
	
/*	public static void main(String[] args) {
		Employee e = new Employee();
		e.setNom("Dalton");
		e.setPrenom("Avrel");
		
		Employee e1 = new Employee();
		e1.setNom("Futé");
		e1.setPrenom("Bizon");
		
		Employee e2 = new Employee();
		e2.setNom("PasLaucasse");
		e2.setPrenom("Rapace");
		
		Employee e3 = new Employee();
		e3.setNom("Spinach");
		e3.setPrenom("Popeye");
		
		ManagedEmployeeBean mn = new ManagedEmployeeBean();
		ManagedServiceBean ms = new ManagedServiceBean();
		Service s = ms.getServiceById(1);
		//mn.createNewEmployee(e);
		//mn.createNewEmployee(e1);
		//mn.createNewEmployee(e2);
		//mn.createNewEmployee(e3);
		e2 = mn.getEmployeById(1);
		mn.alterEmployeeSetService(3, s);
		//System.out.println(e2.getService().getDescription());
		System.out.println(mn.getAllEmployee().toString());
	}*/
	
	public static void main(String[] args) {
		int heureLimitPointage = 15;
		int minuteLimitPointage = 00;
		Calendar todayDate = Calendar.getInstance();
		int nowHour  = todayDate.get(Calendar.HOUR);
		int nowMinute = todayDate.get(Calendar.MINUTE);
		Calendar policie = Calendar.getInstance();
		 
		policie.set(Calendar.HOUR,heureLimitPointage);
		policie.set(Calendar.MINUTE,minuteLimitPointage);
		
		
		System.out.println(policie.get(Calendar.HOUR));
		System.out.println(todayDate.get(Calendar.HOUR));
		System.out.println(todayDate.before(policie));
	}
	
	
}
