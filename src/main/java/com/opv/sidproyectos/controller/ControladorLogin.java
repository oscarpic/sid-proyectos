package com.opv.sidproyectos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opv.sidproyectos.utilidades.UtilidadesProyectos;

@Controller
public class ControladorLogin {

	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {

		if ("opicazo.ext".equalsIgnoreCase(username) && "Sid001*".equalsIgnoreCase(password)) {
			model.addAttribute("proyectos", UtilidadesProyectos.getProyectos());
			return "menu";
		} else {
			return "error";
		}

	}

}
