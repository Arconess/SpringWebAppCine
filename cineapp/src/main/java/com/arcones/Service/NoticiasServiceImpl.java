package com.arcones.Service;

import org.springframework.stereotype.Service;

import com.arcones.Models.Noticia;

@Service
public class NoticiasServiceImpl implements INoticiasService{

	
	
	public NoticiasServiceImpl() {
		System.out.println("Creando una instancia de la clase NoticiasServiceImpl");
	}

	@Override
	public void guardar(Noticia noticia) {
		System.out.println(noticia);
	}

}
