package com.arcones.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	/**
	 * 
	 * Metodo que regresa una lista de Strings con las fechas siguientes, segun el
	 * parametro count
	 * 
	 * @param count
	 * @return
	 */

	public static List<String> getNextDays(int count) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date endDate = cal.getTime();

		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		List<String> nextDays = new ArrayList<String>();
		while (!gcal.getTime().after(endDate)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));
		}

		return nextDays;
	}

	/**
	 * 
	 * Metodo que almacena en la carpeta temporal una imagen y reresa el nombre del
	 * fichero
	 * 
	 * @param
	 * @return
	 */
	public static String guardarImagen(MultipartFile multiPart, HttpServletRequest request) {

		// Obtenemos el nombre original del archivo
		String nombreOriginal = multiPart.getOriginalFilename();
		nombreOriginal = nombreOriginal.replace(" ", "-");
		String nombreFinal = randomAlphaNumeric(8)+nombreOriginal; //Para evitar que se repitan nombres en imagenes

		// Obtenemos la ruta ABSOLUTA del directorio images
		// apache-tomcat/webapps/cineapp/resources/images
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/");

		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro
			File imageFile = new File(rutaFinal + nombreFinal);
			// Almacenamos el fichero en el disco duro
			multiPart.transferTo(imageFile);

			return nombreFinal;
		} catch (IOException e) { // La clase FILE puede lanzar esta excepcion

			System.out.println("Error" + e.getMessage());
			return null;
		}
	}
	
	/**
	 * 
	 * Metodo que genera cadena de caracteres aleatorios
	 * fichero
	 * 
	 * @param
	 * @return
	 */
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567689";
		StringBuilder builder = new StringBuilder();
		while(count-- != 0) {
			int character = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		return builder.toString();
	}
	
}
