package com.umg.econo.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PeriodoDeAfecto.class)
public abstract class PeriodoDeAfecto_ {

	public static volatile SingularAttribute<PeriodoDeAfecto, String> descripcion;
	public static volatile SingularAttribute<PeriodoDeAfecto, Float> monto;
	public static volatile SingularAttribute<PeriodoDeAfecto, Categoria> categoria;
	public static volatile SingularAttribute<PeriodoDeAfecto, Date> inicio;
	public static volatile SingularAttribute<PeriodoDeAfecto, Date> fin;
	public static volatile SingularAttribute<PeriodoDeAfecto, Long> id;

}

