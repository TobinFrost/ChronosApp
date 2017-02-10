package com.chronos.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-01-31T17:47:16.722+0000")
@StaticMetamodel(Permission.class)
public class Permission_ {
	public static volatile SingularAttribute<Permission, Integer> id;
	public static volatile SingularAttribute<Permission, Employee> employee;
	public static volatile SingularAttribute<Permission, Date> debutPermission;
	public static volatile SingularAttribute<Permission, Date> finpermission;
	public static volatile SingularAttribute<Permission, Boolean> accorded;
	public static volatile SingularAttribute<Permission, String> typePermission;
}
