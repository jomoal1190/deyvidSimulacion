package com.umg.econo.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Categoria.class)
public abstract class Categoria_ {

	public static volatile SingularAttribute<Categoria, String> descripcion;
	public static volatile SetAttribute<Categoria, PeriodoDeAfecto> periodo;
	public static volatile SingularAttribute<Categoria, Long> id;
	public static volatile SetAttribute<Categoria, Producto> producto;

}

