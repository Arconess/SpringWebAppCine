package com.arcones.Service;

import java.util.List;

import com.arcones.Models.Banner;

public interface IBannersService {

	void insertar(Banner banner);
	List<Banner> buscarTodos();
}
