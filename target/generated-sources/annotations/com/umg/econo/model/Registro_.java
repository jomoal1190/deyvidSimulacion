package com.umg.econo.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Registro.class)
public abstract class Registro_ {

	public static volatile SingularAttribute<Registro, Empleado> empleado;
	public static volatile SingularAttribute<Registro, Date> fechaCreacion;
	public static volatile SingularAttribute<Registro, Long> id;
	public static volatile SingularAttribute<Registro, Integer> cantidad;
	public static volatile SingularAttribute<Registro, Producto> producto;

}

