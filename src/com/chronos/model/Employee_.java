package com.chronos.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-01-31T17:57:12.315+0000")
@StaticMetamodel(Employee.class)
public class Employee_ {
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, String> nom;
	public static volatile SingularAttribute<Employee, String> prenom;
	public static volatile SingularAttribute<Employee, String> matricule;
	public static volatile SingularAttribute<Employee, String> statusPointage;
	public static volatile SingularAttribute<Employee, Service> service;
	public static volatile SetAttribute<Employee, Pointage> pointages;
}
