package com.arcones.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arcones.Models.Banner;

@Service
public class BannersServiceImpl implements IBannersService {

	List<Banner> banners = null;

	public BannersServiceImpl() {

		System.out.println("Creando una instancia de la clase BannersServiceImpl");

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		try {
			this.banners = new LinkedList<>();

			Banner banner1 = new Banner();
			banner1.setId(0);
			banner1.setTitulo("King Kong");
			banner1.setFecha(formatter.parse("02-05-2017"));
			banner1.setArchivo("slide1.jpg");

			Banner banner2 = new Banner();
			banner2.setId(1);
			banner2.setTitulo("Bella y la Bestia");
			banner2.setFecha(formatter.parse("02-05-2017"));
			banner2.setArchivo("slide2.jpg");

			Banner banner3 = new Banner();
			banner3.setId(2);
			banner3.setTitulo("Spiderman");
			banner3.setFecha(formatter.parse("02-05-2017"));
			banner3.setArchivo("slide3.jpg");

			Banner banner4 = new Banner();
			banner4.setId(3);
			banner4.setTitulo("Cars");
			banner4.setFecha(formatter.parse("02-05-2017"));
			banner4.setArchivo("slide4.jpg");
			
			banners.add(banner1);
			banners.add(banner2);
			banners.add(banner3);
			banners.add(banner4);

		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	@Override
	public void insertar(Banner banner) {
		this.banners.add(banner);
	}

	@Override
	public List<Banner> buscarTodos() {
		return this.banners;
	}

}
