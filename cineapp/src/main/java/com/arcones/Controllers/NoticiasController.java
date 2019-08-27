package com.arcones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.arcones.Models.Noticia;
import com.arcones.Service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	@Autowired
	INoticiasService serviceNoticias;

	@GetMapping(value = "/create")
	public String crear() {

		return "noticias/formNoticia";
	}

//	@PostMapping(value = "/save")
//	public String guardar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String estatus,
//			@RequestParam("detalle") String detalle) {
//
//		Noticia noticia = new Noticia();
//		noticia.setTitulo(titulo);
//		noticia.setEstatus(estatus);
//		noticia.setDetalle(detalle);
//
//		// Pendient guardar en BBDD
//		
//		serviceNoticias.guardar(noticia);
//
//		return "/noticias/formNoticia";
//	}

	// Spring crea y guarda en el un nuevo objeto si detecta que el formulario pasa
	// parametros con el mismo nombre que las propiedades de la clase noticia
	@PostMapping(value = "/save")
	public String guardar(Noticia noticia) {

		// Pendient guardar en BBDD

		serviceNoticias.guardar(noticia);

		return "/noticias/formNoticia";
	}

}
