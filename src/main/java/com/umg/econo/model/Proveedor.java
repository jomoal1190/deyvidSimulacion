package com.umg.econo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_proveedor")
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="proveedor")
	@JsonManagedReference
	Set<Producto> producto = new HashSet<Producto>();
	
	
	
	public Proveedor() {
	}
	public Proveedor(Long id, String nombre, Set<Producto> producto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.producto = producto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Producto> getProducto() {
		return producto;
	}
	public void setProducto(Set<Producto> producto) {
		this.producto = producto;
	}
	
	
	
}
