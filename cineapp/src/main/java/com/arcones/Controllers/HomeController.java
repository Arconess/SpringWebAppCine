package com.arcones.Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.arcones.Models.Banner;
import com.arcones.Models.Pelicula;
import com.arcones.Service.IBannersService;
import com.arcones.Service.IPeliculasService;
import com.arcones.util.Utileria;

@Controller
public class HomeController {

	@Autowired
	private IPeliculasService servicePeliculas;

	@Autowired
	private IBannersService serviceBanners;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public String goHome() {
//
//		return "home";
//	}

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String mostrarPrincipal(Model model) {
//
//		List<String> peliculas = new LinkedList<>();
//		peliculas.add("Fast and Furious");
//		peliculas.add("Olga antes molaba");
//		peliculas.add("Aliens");
//
//		model.addAttribute("peliculas", peliculas);
//
//		return "home";
//	}

//	@RequestMapping(value = "/", method = RequestMethod.GET) //Se puede cambiar por @GetMapping(value="/")
//	public String mostrarPrincipal(Model model) throws ParseException {
//
//		List<Pelicula> peliculas = new LinkedList<>();
//		
//		List<String> listaFechas = Utileria.getNextDays(4); //Obtener las 4 siguientes fechas
//
////		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//		Date fecha1 = dateFormat.parse("02-05-2017");
//		Date fecha2 = dateFormat.parse("20-05-2017");
//		Date fecha3 = dateFormat.parse("30-06-2017");
//		Date fecha4 = dateFormat.parse("27-08-2017");
//
//		Pelicula pelicula1 = new Pelicula(1, "En este Rincón del Mundo", 130, "A", "Drama", fecha1);
//		Pelicula pelicula2 = new Pelicula(2, "Logan: Wolverine", 135, "C", "Acción", fecha2);
//		Pelicula pelicula3 = new Pelicula(3, "Fragmentado", 118, "B15", "Thriller", fecha3);
//		Pelicula pelicula4 = new Pelicula(4, "Kong La Isla Calavera", 118, "B", "Acción y aventura", fecha4);
//
//		pelicula1.setImagen("estreno1.png");
//		pelicula2.setImagen("estreno2.png");
//		pelicula3.setImagen("estreno3.png");
//		pelicula4.setImagen("estreno4.png");
//
//		pelicula4.setEstatus("Inactiva");
//
//		peliculas.add(pelicula1);
//		peliculas.add(pelicula2);
//		peliculas.add(pelicula3);
//		peliculas.add(pelicula4);
//
//		model.addAttribute("fechas", listaFechas);
//		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
//		model.addAttribute("peliculas", peliculas);
//
//		return "home";
//	}

	@RequestMapping(value = "/", method = RequestMethod.GET) // Se puede cambiar por @GetMapping(value="/")
	public String mostrarPrincipal(Model model) throws ParseException {

		List<String> listaFechas = Utileria.getNextDays(4); // Obtener las 4 siguientes fechas

		List<Banner> banners = serviceBanners.buscarTodos();
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();

		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners", banners);

		return "home";
	}

//	@RequestMapping(value = "/search", method =RequestMethod.POST) //Se puede cambiar por @PostMapping(value="/search")
//	public String buscar(@RequestParam("fecha") String fecha, Model model) throws ParseException {
//		
//		List<Pelicula> peliculas = new LinkedList<>();
//		
//		List<String> listaFechas = Utileria.getNextDays(4);
//
//		Date fecha1 = dateFormat.parse("02-05-2017");
//		Date fecha2 = dateFormat.parse("20-05-2017");
//		Date fecha3 = dateFormat.parse("30-06-2017");
//		Date fecha4 = dateFormat.parse("27-08-2017");
//
//		Pelicula pelicula1 = new Pelicula(1, "En este Rincón del Mundo", 130, "A", "Drama", fecha1);
//		Pelicula pelicula2 = new Pelicula(2, "Logan: Wolverine", 135, "C", "Acción", fecha2);
//		Pelicula pelicula3 = new Pelicula(3, "Fragmentado", 118, "B15", "Thriller", fecha3);
//		Pelicula pelicula4 = new Pelicula(4, "Kong La Isla Calavera", 118, "B", "Acción y aventura", fecha4);
//
//		pelicula1.setImagen("estreno1.png");
//		pelicula2.setImagen("estreno2.png");
//		pelicula3.setImagen("estreno3.png");
//		pelicula4.setImagen("estreno4.png");
//
//		pelicula4.setEstatus("Inactiva");
//
//		peliculas.add(pelicula1);
//		peliculas.add(pelicula2);
//		peliculas.add(pelicula3);
//		peliculas.add(pelicula4);
//
//		model.addAttribute("fechas", listaFechas);
//		model.addAttribute("fechaBusqueda", fecha);
//		model.addAttribute("peliculas", peliculas);
//		
//		System.out.println("Fecha buscada:" + fecha);
//		
//		return "home";
//	}

	@RequestMapping(value = "/search", method = RequestMethod.POST) // Se puede cambiar por
																	// @PostMapping(value="/search")
	public String buscar(@RequestParam("fecha") String fecha, Model model) throws ParseException {

		List<String> listaFechas = Utileria.getNextDays(4);

		List<Pelicula> peliculas = servicePeliculas.buscarTodas();

		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);

		System.out.println("Fecha buscada:" + fecha);

		return "home";
	}

//	@RequestMapping(value = "/detail", method = RequestMethod.GET)
//	public String mostrarDetalle(Model model) {
//
//		String tituloPelicula = "Olga es una friki de los escapes";
//		int duracion = 136;
//		double precioEntrada = 10;
//
//		model.addAttribute("titulo", tituloPelicula);
//		model.addAttribute("duracion", duracion);
//		model.addAttribute("precio", precioEntrada);
//		return "detalle";
//	}

	// Representa las variables en la url asi: /fecha/titulo.....

	@RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha) {

		System.out.println("Buscando horarios para la pelicula: " + idPelicula);
		System.out.println("Para la fecha: " + fecha);

		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		return "detalle";
	}

//Representa las variables en la url asi: /crear?titulo="sfasdas"&fecha=12/43.......
//	
//	@RequestMapping(value = "/detail", method = RequestMethod.GET) //Se puede cambiar por @GetMapping(value="/detail")
//	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha) {
//
//		System.out.println("Buscando horarios para la pelicula: " + idPelicula);
//		System.out.println("Para la fecha: " + fecha);
//
//		String tituloPelicula = "Olga es una friki de los escapes";
//		int duracion = 136;
//		double precioEntrada = 10;
//
//		model.addAttribute("titulo", tituloPelicula);
//		model.addAttribute("duracion", duracion);
//		model.addAttribute("precio", precioEntrada);
//		return "detalle";
//	}
}
