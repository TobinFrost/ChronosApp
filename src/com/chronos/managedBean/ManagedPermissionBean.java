package com.chronos.managedBean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.chronos.model.Employee;
import com.chronos.model.Permission;


public class ManagedPermissionBean {

	public ManagedPermissionBean() {
		// TODO Auto-generated constructor stub
	}

	public Permission createNewPermission(Permission p){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			return p;
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}
		
	
	public List<Permission> getPermissionNotAccorded(Employee e){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				Query q = em.createNamedQuery("PermissionNotAccorded");
				q.setParameter("employee", e);
				
			return q.getResultList();
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}
	
	public List<Permission> allPermission(){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				Query q = em.createNamedQuery("allPermissions");
				
			return q.getResultList();
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}
	
	public List<Permission> allNotAccordedPermission(){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
				Query q = em.createNamedQuery("listNotAccorded");
				
			return q.getResultList();
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}
	
	
		public Permission getPermissionById (int id){
		
			EntityManager em = ResourceBean.getEmf().createEntityManager();
			try {
				return (Permission) em.find(Permission.class, id);
				
			} finally {
				// TODO: handle finally clause
				em.close();
			}
			
		}
		
		public Permission alterPermissionAutorization(int id,boolean accorded){
			
			EntityManager em = ResourceBean.getEmf().createEntityManager();
			try {
				em.getTransaction().begin();
				 Permission p = em.find(Permission.class, id);
				 p.setAccorded(accorded);
				 em.getTransaction().commit();
				 return p;
				
			} finally {
				// TODO: handle finally clause
				em.close();
			}
			
		}
		
		
		
		public static void main(String[] args) {
			ManagedPermissionBean mp = new ManagedPermissionBean();
			ManagedEmployeeBean me = new ManagedEmployeeBean();
			Employee e = me.getEmployeById(2);
			Permission p = new Permission();
			p.setEmployee(e);
			p.setTypePermission(Permission.TypePermission_RTT);
			
			Calendar debut =Calendar.getInstance();
			debut.clear();
			debut.set(2016, Calendar.DECEMBER, 25);
			Date datedebutpermi = debut.getTime();
			Calendar fin =Calendar.getInstance();
			fin.clear();
			fin.set(2017, Calendar.JANUARY, 15);
			Date datefinpermi = fin.getTime();
			p.setDebutPermission(datedebutpermi);
			p.setFinpermission(datefinpermi);
			
			mp.createNewPermission(p);
			//System.out.println(mp.getPermissionNotAccorded(e).get(0).getTypePermission());
			
			
		}
	
	
}
