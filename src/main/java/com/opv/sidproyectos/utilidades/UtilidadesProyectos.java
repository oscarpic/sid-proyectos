package com.opv.sidproyectos.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.opv.sidproyectos.filehandler.FileHandlerProyectos;
import com.opv.sidproyectos.model.BeanProyecto;

public class UtilidadesProyectos {

	public static final int CODIGO = 0;
	public static final int NOMBRE = 1;

	public static List<BeanProyecto> getProyectos() {

		FileHandlerProyectos fhp = new FileHandlerProyectos();
		List<String> listaStrProyectos = fhp.leerProyectos();

		List<BeanProyecto> resultado = new ArrayList<BeanProyecto>();

		for (String strProyectos : listaStrProyectos) {

			String proyecto[] = strProyectos.split("\\|");

			BeanProyecto beanProyecto = new BeanProyecto();
			beanProyecto.setCodigo(proyecto[CODIGO]);
			beanProyecto.setNombre(proyecto[NOMBRE]);

			resultado.add(beanProyecto);
		}

		return resultado;
	}

	public static void guardarCambiosProyecto(String oldValue, String newValue, String codigoProyecto, int campo) {

		FileHandlerProyectos fhp = new FileHandlerProyectos();
		List<String> listaStrProyectos = fhp.leerProyectos();
		List<String> record = new ArrayList<String>();

		for (String strProyectos : listaStrProyectos) {

			String proyecto[] = strProyectos.split("\\|");

			if (codigoProyecto.equals(proyecto[CODIGO]) && proyecto[campo].equals(oldValue)) {
				proyecto[campo] = newValue;
				strProyectos = String.join("|", proyecto);
			}

			record.add(strProyectos);
		}

		fhp.grabarProyectos(record);

	}

}
