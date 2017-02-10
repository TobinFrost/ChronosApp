package com.chronos.managedBean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.chronos.model.Employee;
import com.chronos.model.Pointage;
import com.chronos.model.Service;

public class ManagedPointageBean {

	public ManagedPointageBean() {
		// TODO Auto-generated constructor stub
	}
	
	public Pointage createNewPointage(Pointage p){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				em.getTransaction().begin();
				em.persist(p);
				em.getTransaction().commit();
				return p;
		}catch(Exception e){
				System.out.println("Impossible de créer le pointage");
				p = null;
		}finally {
		}
			em.close();
			return p;
		}
	public Pointage getCurrentPointage(Service s){
		
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				Date currentDate = Calendar.getInstance().getTime();
				Query q = em.createNamedQuery("currentPointage");
				q.setParameter("currentDate", currentDate);
				q.setParameter("service", s);
				return (Pointage) q.getSingleResult();
				
		}
		
		catch(Exception e){
			System.out.println("Pointage courant Inexistant");
			/*System.out.println("Creation nouveau Pointage ...");
			Pointage p = new Pointage();
			System.out.println("Nouveau Pointage creer avec succes");
			System.out.println("Service associé au pointage non défini");
			return  createNewPointage(p);*/
			return null;
		}
		finally {
		
			em.close();
			
		}
		
	}

	
public List<Pointage> allPointage(){
		
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
			Query q = em.createNamedQuery("listAllPointage",Pointage.class);
			return  q.getResultList();
		} finally {
			// TODO: handle finally clause
			em.close();
		}
}
	
	
public List<Pointage> getCurrentPointageByDate(){
		
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				Date currentDate = Calendar.getInstance().getTime();
				Query q = em.createNamedQuery("currentPointageByDate");
				q.setParameter("currentDate", currentDate);
				return  q.getResultList();
				
		}
		
		catch(Exception e){
			System.out.println("Pointage courant Inexistant");
			/*System.out.println("Creation nouveau Pointage ...");
			Pointage p = new Pointage();
			System.out.println("Nouveau Pointage creer avec succes");
			System.out.println("Service associé au pointage non défini");
			return  createNewPointage(p);*/
			return null;
		}
		finally {
		
			em.close();
			
		}
		
	}

	
	
	/**
	 * @param Employee e Employe to add to the current Pointage Employee List
	 * @param int id 
	 * 
	 * 
	 */
	
	public void alterPointageAddEmployee(Employee e,Service s){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		int currentId = getCurrentPointage(s).getId();
		try {
				em.getTransaction().begin();
					 Pointage p = em.find(Pointage.class, currentId);
					p.getEmployees().add(e);
				em.getTransaction().commit();
				
		}catch(Exception e1){
				System.out.println("Impossible de Pointer cet Employe");
		}finally {
		
			em.close();
			
		}
	}
	
	public static void main(String[] args) {
		
		ManagedPointageBean mp = new ManagedPointageBean();
		ManagedEmployeeBean me = new ManagedEmployeeBean();
		ManagedServiceBean ms = new ManagedServiceBean();
		
		Service s = ms.getServiceById(1);
		Pointage p = new Pointage();
		//p.setService(s);
		
		//mp.createNewPointage(p);
		
		//System.out.println(p.getDatePointage()); // Test Validité de la date
		//p = mp.getCurrentPointage(s);
		p = mp.allPointage().get(2);
		/*Employee e = me.getEmployeById(3);
		me.alterEmployeeSetStatusPointage(e.getId(),23,00);
		mp.alterPointageAddEmployee(e,s);
		p = mp.getCurrentPointage(s);
		p.getEmployees().add(e);*/
		System.out.println(p.getEmployees().toArray()[1]);
		
	}
	
	
}
