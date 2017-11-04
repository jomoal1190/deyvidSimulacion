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
@Table(name="empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@Column (name="porcentaje")
	private Float porcentaje;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="empleado")
	@JsonManagedReference
	Set<Registro> registros = new HashSet<Registro>();
	
	
	
	
	
	public Empleado() {
	}
	public Empleado(Long id, String nombre, Float porcentaje, Set<Registro> registros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.porcentaje = porcentaje;
		this.registros = registros;
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
	public Float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Float porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Set<Registro> getRegistros() {
		return registros;
	}
	public void setRegistros(Set<Registro> registros) {
		this.registros = registros;
	}
	
	
	
}
