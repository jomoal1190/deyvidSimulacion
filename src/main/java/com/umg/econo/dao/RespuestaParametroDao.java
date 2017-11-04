package com.umg.econo.dao;

import java.util.ArrayList;
import java.util.List;

public class RespuestaParametroDao<T> extends RespuestaGeneralDao{
	
	List<T> lista = new ArrayList<T>();

	public List<T> getLista() {
		return lista;
	}

	public void setLista(List<T> lista) {
		this.lista = lista;
	}
	

}
