package com.umg.econo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="registro")
public class Registro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_regitro")
	private Long id;
	@Column(name="fecha_creacion")
	@Type(type="date")
	private Date fechaCreacion;
	@Column(name="cantidad")
	private Integer cantidad;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="id_producto")
	private Producto producto;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="id_empleado")
	private Empleado empleado;
	
	
	public Registro() {}
	
	
	public Registro(Long id, Date fechaCreacion, Integer cantidad, Producto producto, Empleado empleado) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.cantidad = cantidad;
		this.producto = producto;
		this.empleado = empleado;
	}

	

	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	

}
