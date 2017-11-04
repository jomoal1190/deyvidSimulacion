package com.umg.econo.dao;

import com.umg.econo.model.Producto;

public class RespuestaBDanio {
	
	
	private String anio;
	private Integer suma;
	private Float total;
	
	
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	
	public Integer getSuma() {
		return suma;
	}
	public void setSuma(Integer suma) {
		this.suma = suma;
	}
	
	
	

}
