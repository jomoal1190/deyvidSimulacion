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
@Table(name="registros_alterados")
public class RegistrosAlterados {
	
	@Id
	@Column(name="id_regitro")
	private Long id;
	@Column(name="fecha_creacion")
	@Type(type="date")
	private Date fechaCreacion;
	@Column(name="cantidad")
	private Double cantidad;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	
	
	
	public RegistrosAlterados() {
	}
	public RegistrosAlterados(Long id, Date fechaCreacion, Double cantidad, Producto producto) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.cantidad = cantidad;
		this.producto = producto;
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
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	

}
