package com.umg.econo.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Empleado.class)
public abstract class Empleado_ {

	public static volatile SetAttribute<Empleado, Registro> registros;
	public static volatile SingularAttribute<Empleado, Long> id;
	public static volatile SingularAttribute<Empleado, Float> porcentaje;
	public static volatile SingularAttribute<Empleado, String> nombre;

}

