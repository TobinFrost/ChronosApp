package com.chronos.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-01-31T22:25:41.896+0000")
@StaticMetamodel(HorairePolicie.class)
public class HorairePolicie_ {
	public static volatile SingularAttribute<HorairePolicie, Integer> id;
	public static volatile SingularAttribute<HorairePolicie, Integer> heureLimitPointage;
	public static volatile SingularAttribute<HorairePolicie, Integer> minuteLimitPointage;
	public static volatile SingularAttribute<HorairePolicie, Integer> heureDebutPause;
	public static volatile SingularAttribute<HorairePolicie, Integer> minuteDebutPause;
	public static volatile SingularAttribute<HorairePolicie, Integer> heureFinPause;
	public static volatile SingularAttribute<HorairePolicie, Integer> minuteFinPause;
}
