package com.arcones.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arcones.Models.Noticia;

//Genera CRUD de forma automatica

@Repository									//El name de este repoositoryo es noticiasRepository al no haberle dado otro (nombre clase con primera minuscula)
public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {

}
