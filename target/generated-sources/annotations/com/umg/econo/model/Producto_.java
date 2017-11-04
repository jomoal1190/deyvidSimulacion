package com.umg.econo.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Producto.class)
public abstract class Producto_ {

	public static volatile SetAttribute<Producto, RegistrosAlterados> registrosAlterados;
	public static volatile SingularAttribute<Producto, Double> precio;
	public static volatile SingularAttribute<Producto, Categoria> categoria;
	public static volatile SetAttribute<Producto, Registro> registros;
	public static volatile SingularAttribute<Producto, Proveedor> proveedor;
	public static volatile SingularAttribute<Producto, Long> id;
	public static volatile SingularAttribute<Producto, String> nombre;

}

