package com.chronos.managedBean;

import javax.persistence.EntityManager;

import com.chronos.model.HorairePolicie;

public class ManagedPolicieBean {

	public ManagedPolicieBean() {
		// TODO Auto-generated constructor stub
	}

	public HorairePolicie createNewPolicie(HorairePolicie h){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(h);
			em.getTransaction().commit();
			return h;
			} finally {
				em.close();
			}
	}
	
	public HorairePolicie alterPolicie(HorairePolicie h){
		
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
				HorairePolicie hp = em.find(HorairePolicie.class, h.getId());
				hp.setHeureDebutPause(h.getHeureDebutPause());
				hp.setHeureFinPause(h.getHeureFinPause());
				hp.setHeureLimitPointage(h.getHeureLimitPointage());
				hp.setMinuteDebutPause(h.getMinuteDebutPause());
				hp.setMinuteFinPause(h.getMinuteFinPause());
				hp.setMinuteLimitPointage(h.getMinuteLimitPointage());
			em.getTransaction().commit();
			return h;
			} finally {
				em.close();
			}
		
	}
	
	public HorairePolicie getPolicie(){
		EntityManager em = ResourceBean.getEmf().createEntityManager();
		try {
			return em.find(HorairePolicie.class, 1);
		} finally {
			em.close();
		}
	}
	
	public static void main(String[] args) {
		ManagedPolicieBean mpb = new ManagedPolicieBean();
		mpb.createNewPolicie(new HorairePolicie());
	}
	
}
