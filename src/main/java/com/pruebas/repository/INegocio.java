package com.pruebas.repository;

import java.util.List;

import com.pruebas.model.Negocio;

public interface INegocio extends BaseRepository<Negocio>{

	public List<Negocio> getAll(int id_encargado);
}
