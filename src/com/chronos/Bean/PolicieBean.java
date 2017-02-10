package com.chronos.Bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.chronos.managedBean.ManagedPolicieBean;
import com.chronos.model.HorairePolicie;

@ManagedBean(name="policieBean")
public class PolicieBean {
private ManagedPolicieBean managedPolicieBean = new ManagedPolicieBean();
private HorairePolicie policie = new HorairePolicie();
	public PolicieBean() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the policie
	 */
	
	@PostConstruct
	public void init(){
		policie = managedPolicieBean.getPolicie();
	}
	
	public HorairePolicie getPolicie() {
		return policie;
	}
	
	/**
	 * @param policie the policie to set
	 */
	public void setPolicie(HorairePolicie policie) {
		this.policie = policie;
	}

	public void modifyPolicie(){
		info();
		managedPolicieBean.alterPolicie(policie);
	}
	
	public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Politique Horaire mise à jour "));
    }
	
}
