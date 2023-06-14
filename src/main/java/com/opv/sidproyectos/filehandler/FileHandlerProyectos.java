package com.opv.sidproyectos.filehandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

public class FileHandlerProyectos {

	public List<String> leerProyectos() {
		List<String> proyectos = new ArrayList<>();
		try {
			// Obtener el archivo proyectos.data desde el classpath del proyecto
			File file = new ClassPathResource("proyectos.data").getFile();
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String linea;
			while ((linea = reader.readLine()) != null) {
				proyectos.add(linea);
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return proyectos;
	}

	public void grabarProyectos(List<String> proyectos) {
		try {
			// Obtener el archivo proyectos.data desde el classpath del proyecto
			File file = new ClassPathResource("proyectos.data").getFile();

			// Crear una copia de seguridad llamada proyectos.data.back si ya existe
			File backupFile = new File(file.getParent(), "proyectos.data.back");
			if (backupFile.exists()) {
				backupFile.delete();
			}
			file.renameTo(backupFile);

			// Eliminar el archivo proyectos.data si existe
			if (file.exists()) {
				file.delete();
			}

			// Crear un nuevo archivo proyectos.data con el contenido de la lista de
			// proyectos
			FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8);
			for (String proyecto : proyectos) {
				writer.write(proyecto);
				writer.write(System.lineSeparator());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
