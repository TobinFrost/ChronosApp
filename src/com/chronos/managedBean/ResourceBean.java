package com.chronos.managedBean;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ResourceBean {
	private static final String JPA_UNIT_NAME = "ChronosApp";
	private static EntityManagerFactory emf;
	public ResourceBean() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the emf
	 */
	public static EntityManagerFactory getEmf() {
		if(emf == null){
			emf = Persistence.createEntityManagerFactory(JPA_UNIT_NAME);
		}
		return emf;
	}
	

}
