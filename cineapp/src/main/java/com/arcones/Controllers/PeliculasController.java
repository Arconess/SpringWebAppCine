package com.arcones.Controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arcones.Models.Pelicula;
import com.arcones.Service.IPeliculasService;
import com.arcones.util.Utileria;

@Controller
@RequestMapping(value = "/peliculas")
public class PeliculasController {

	@Autowired
	private IPeliculasService servicePeliculas;

	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {

		List<Pelicula> peliculas = servicePeliculas.buscarTodas();

		model.addAttribute("peliculas", peliculas);

		return "peliculas/listPeliculas";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model) {
		
		model.addAttribute("generos", servicePeliculas.buscarGeneros());

		return "peliculas/formPelicula";
	}

	// result recoge os errores que aparezcan al hacer el Binding de java(Auto coger
	// variables y crear clase con ellas)
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes atributes,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println("Se han dado errores");
			return "peliculas/formPelicula"; // Si hay errores volvemos al formulario
		}

		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			pelicula.setImagen(nombreImagen);
		}

		// Muestra los errores en la consola
//		for(ObjectError error : result.getAllErrors()) {
//			System.out.println(error.getDefaultMessage());
//		}

		System.out.println("Recibiendo objeto pelicula: " + pelicula);

		System.out.println("Elementos antes de la inserccion: " + servicePeliculas.buscarTodas().size());
		servicePeliculas.insertar(pelicula);
		System.out.println("Elementos antes de la inserccion: " + servicePeliculas.buscarTodas().size());

		// Flash atribute porque no se envia un model al redireccionar, esta variable se
		// almacena en la sesion y se borra al usarse
		atributes.addFlashAttribute("mensaje", "El Registro fue Guardado");

		// Se usa redirect para que al utilizar el boton reload no se vuelva a enviar la
		// peticion de guardar (Usar al modificar, crear o eliminar datos), usa GET
//		return "peliculas/listPeliculas";
		return "redirect:/peliculas/index"; // Sino hay errores vamos a la lista de peliculas
	}

	// Modifica la forma de transforar las fechas(string -> date) en el binding(Es
	// llamado de forma automatica por spring)
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
