package com.umg.econo.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.umg.econo.objetosCalculos.CalculoFuncionCuadratica;
import com.umg.econo.objetosCalculos.CalculoMinimosCuadrados;
import com.umg.econo.objetosCalculos.CalculoRegresionLineal;
import com.umg.econo.objetosCalculos.RespuestaFuncionCuadratica;
import com.umg.econo.objetosCalculos.RespuestaMinimos;
import com.umg.econo.objetosCalculos.RespuestaRegresionLineal;

public interface CalculosService {
	public RespuestaMinimos valoresMinimos(List<CalculoMinimosCuadrados> calculos);
	public RespuestaRegresionLineal valoresRegresion(List<CalculoRegresionLineal> calculos);
	// METODO DE VARIANZA MEDIA SIN USUAR
	public RespuestaRegresionLineal valoresRegresionCalculob(List<CalculoRegresionLineal> calculos);
	public RespuestaFuncionCuadratica valoresFuncionCuadratica(List<CalculoFuncionCuadratica> calculos);
	public TreeMap<Integer,Float> unificarAnios(List<Map> mapa);
	public TreeMap<Integer,Float> unificarMes(List<Map> mapa);
		

}
