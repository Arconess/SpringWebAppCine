package com.arcones.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arcones.Models.Banner;
import com.arcones.Service.IBannersService;
import com.arcones.util.Utileria;

@Controller
@RequestMapping("/banners")
public class BannersController {

	@Autowired
	private IBannersService serviceBanners;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<Banner> banners = serviceBanners.buscarTodos();

		model.addAttribute("banners", banners);

		return "banners/listBanners";
	}

	@GetMapping("/create")
	public String crear() {

		return "banners/formBanner";
	}

	@PostMapping("/save")
	public String guardar(Banner banner, BindingResult result, @RequestParam("archivoImagen") MultipartFile multiPart,
			HttpServletRequest request, RedirectAttributes atributes) {
		
		if (result.hasErrors()) {
			System.out.println("Se han dado errores");
			return "peliculas/formPelicula";
		}

		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			banner.setArchivo(nombreImagen);
		}
		
		serviceBanners.insertar(banner);
		
		atributes.addFlashAttribute("mensaje", "El Registro fue Guardado");

		return "redirect:/banners/index";
	}

}
