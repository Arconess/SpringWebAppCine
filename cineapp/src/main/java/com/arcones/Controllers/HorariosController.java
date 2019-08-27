package com.arcones.Controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.arcones.Models.Horario;
import com.arcones.Models.Pelicula;
import com.arcones.Service.IPeliculasService;

@Controller
@RequestMapping(value="/horarios")
public class HorariosController {
	
	@Autowired
	IPeliculasService servicePeliculas;

	@GetMapping("/create")
	public String crear(@ModelAttribute Horario horario, Model model) {
		
		model.addAttribute("peliculas", servicePeliculas.buscarTodas());
		
		return "horarios/formHorario";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model) {
		
		if (result.hasErrors()){
			List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
			model.addAttribute("peliculas", listaPeliculas);
			return "horarios/formHorario";
		}
		
		System.out.println("Guardando el objeto Horario: " + horario);
		return "redirect:/horarios/create";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
