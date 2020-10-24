package com.pruebas.repository;

import java.util.List;

import com.pruebas.model.Producto;

public interface IProducto extends BaseRepository<Producto>{

	
	public List<Producto> getAll(int id_negocio);
}
