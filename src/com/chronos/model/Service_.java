package com.chronos.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-01-31T17:47:16.756+0000")
@StaticMetamodel(Service.class)
public class Service_ {
	public static volatile SingularAttribute<Service, Integer> id;
	public static volatile SingularAttribute<Service, String> nom;
	public static volatile SingularAttribute<Service, String> description;
	public static volatile SingularAttribute<Service, Employee> lead;
	public static volatile SetAttribute<Service, Employee> employees;
}
