package com.chronos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HorairePolicie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private   int heureLimitPointage;
	private  int minuteLimitPointage;
	
	private  int heureDebutPause;
	private  int minuteDebutPause;
	
	private  int heureFinPause;
	private  int minuteFinPause;
	public HorairePolicie() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the heureLimitPointage
	 */
	public  int getHeureLimitPointage() {
		return heureLimitPointage;
	}
	
	public int getId(){
		return id;
	}
	
	/**
	 * @param heureLimitPointage the heureLimitPointage to set
	 */
	public  void setHeureLimitPointage(int heureLimitPointage) {
		this.heureLimitPointage = heureLimitPointage;
	}
	/**
	 * @return the minuteLimitPointage
	 */
	public  int getMinuteLimitPointage() {
		return minuteLimitPointage;
	}
	/**
	 * @param minuteLimitPointage the minuteLimitPointage to set
	 */
	public  void setMinuteLimitPointage(int minuteLimitPointage) {
		this.minuteLimitPointage = minuteLimitPointage;
	}
	/**
	 * @return the heureDebutPause
	 */
	public  int getHeureDebutPause() {
		return heureDebutPause;
	}
	/**
	 * @param heureDebutPause the heureDebutPause to set
	 */
	public  void setHeureDebutPause(int heureDebutPause) {
		this.heureDebutPause = heureDebutPause;
	}
	/**
	 * @return the minuteDebutPause
	 */
	public  int getMinuteDebutPause() {
		return minuteDebutPause;
	}
	/**
	 * @param minuteDebutPause the minuteDebutPause to set
	 */
	public  void setMinuteDebutPause(int minuteDebutPause) {
		this.minuteDebutPause = minuteDebutPause;
	}
	/**
	 * @return the heureFinPause
	 */
	public  int getHeureFinPause() {
		return heureFinPause;
	}
	/**
	 * @param heureFinPause the heureFinPause to set
	 */
	public  void setHeureFinPause(int heureFinPause) {
		this.heureFinPause = heureFinPause;
	}
	/**
	 * @return the minuteFinPause
	 */
	public  int getMinuteFinPause() {
		return minuteFinPause;
	}
	/**
	 * @param minuteFinPause the minuteFinPause to set
	 */
	public  void setMinuteFinPause(int minuteFinPause) {
		this.minuteFinPause = minuteFinPause;
	}

}
