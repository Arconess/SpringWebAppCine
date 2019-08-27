package com.arcones.Service;

import java.util.List;

import com.arcones.Models.Pelicula;

public interface IPeliculasService {

	void insertar(Pelicula pelicula);
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
	List<String> buscarGeneros();

}
