package com.chronos.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-01-31T17:47:16.740+0000")
@StaticMetamodel(Pointage.class)
public class Pointage_ {
	public static volatile SingularAttribute<Pointage, Integer> id;
	public static volatile SingularAttribute<Pointage, Date> datePointage;
	public static volatile SingularAttribute<Pointage, Service> service;
	public static volatile SetAttribute<Pointage, Employee> employees;
}
