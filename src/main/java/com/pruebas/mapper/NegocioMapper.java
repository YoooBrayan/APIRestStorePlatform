package com.pruebas.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pruebas.model.Negocio;

public class NegocioMapper implements RowMapper<Negocio> {

	@Override
	public Negocio mapRow(ResultSet rs, int rowNum) throws SQLException {

		Negocio negocio = new Negocio();
		negocio.setId(rs.getInt("id"));
		negocio.setNombre(rs.getString("nombre"));
		negocio.setFoto(rs.getString("foto"));
		negocio.setId_encargado(rs.getInt("id_encargado"));
		negocio.setTipo(rs.getInt("tipo"));
		return negocio;
	}

}
