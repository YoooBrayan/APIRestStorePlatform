package com.pruebas.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pruebas.model.Usuario;

public class UsuarioMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		usuario.setId(rs.getInt(("id")));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setTipo_documento(rs.getInt("tipo_documento"));
		usuario.setNumero_documento(rs.getString("numero_documento"));
		usuario.setNit(rs.getInt("nit"));
		usuario.setEmail(rs.getString("email"));
		return usuario;
	}
	

}
