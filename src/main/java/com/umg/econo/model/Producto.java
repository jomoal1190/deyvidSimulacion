package com.umg.econo.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_producto")
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="precio_unitario")
	private Double precio;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="producto")
	@JsonManagedReference
	Set<Registro> registros = new HashSet<Registro>();
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="producto")
	@JsonManagedReference
	Set<RegistrosAlterados> registrosAlterados = new HashSet<RegistrosAlterados>();
	
	
	public Set<RegistrosAlterados> getRegistrosAlterados() {
		return registrosAlterados;
	}


	public void setRegistrosAlterados(Set<RegistrosAlterados> registrosAlterados) {
		this.registrosAlterados = registrosAlterados;
	}


	public Producto() {}
	

	

	public Producto(Long id, String nombre, Double precio, Set<Registro> registros, Categoria categoria,
			Proveedor proveedor, Set<RegistrosAlterados> registrosAlterados) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.registros = registros;
		this.categoria = categoria;
		this.proveedor = proveedor;
		this.registrosAlterados = registrosAlterados;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Set<Registro> getRegistros() {
		return registros;
	}
	public void setRegistros(Set<Registro> registros) {
		this.registros = registros;
	}
	
	
	

}
