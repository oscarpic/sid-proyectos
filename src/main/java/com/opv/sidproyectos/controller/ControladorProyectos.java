package com.opv.sidproyectos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opv.sidproyectos.utilidades.UtilidadesProyectos;

@Controller
public class ControladorProyectos {

	private static final Logger log = LoggerFactory.getLogger(ControladorProyectos.class);

	@PostMapping("/guardarCambios")
	@ResponseBody
	public String guardarCambios(@RequestParam("oldValue") String oldValue, @RequestParam("newValue") String newValue,
			@RequestParam("idProyecto") String idProyecto, @RequestParam("idCelda") String idCelda) {

		try {

			log.info(oldValue + " - " + newValue + " - " + idProyecto + " - " + idCelda);
			String[] auxCelda = idCelda.split("-");
			UtilidadesProyectos.guardarCambiosProyecto(oldValue, newValue, idProyecto, Integer.parseInt(auxCelda[0]));

		} catch (Exception e) {
			return "false";
		}

		return "true";

	}

}
