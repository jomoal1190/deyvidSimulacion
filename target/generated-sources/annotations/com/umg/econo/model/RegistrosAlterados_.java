package com.umg.econo.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RegistrosAlterados.class)
public abstract class RegistrosAlterados_ {

	public static volatile SingularAttribute<RegistrosAlterados, Date> fechaCreacion;
	public static volatile SingularAttribute<RegistrosAlterados, Long> id;
	public static volatile SingularAttribute<RegistrosAlterados, Double> cantidad;
	public static volatile SingularAttribute<RegistrosAlterados, Producto> producto;

}

