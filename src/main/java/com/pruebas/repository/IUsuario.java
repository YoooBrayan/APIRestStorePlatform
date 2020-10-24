package com.pruebas.repository;

import com.pruebas.model.Usuario;

public interface IUsuario extends BaseRepository<Usuario>{

	public Usuario getByEmailAndPassword(String email, String password);
}
