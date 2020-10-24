package com.pruebas.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pruebas.model.Producto;

public class ProductoMapper implements RowMapper<Producto>{

	@Override
	public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {

		Producto producto = new Producto();
		producto.setId(rs.getInt("id"));
		producto.setNombre(rs.getString("nombre"));
		producto.setDescripcion(rs.getString("descripcion"));
		producto.setTipo(rs.getInt("tipo"));
		producto.setCantidad(rs.getInt("cantidad"));
		producto.setValor(rs.getInt("valor"));
		producto.setFoto(rs.getString("foto"));
		producto.setId_negocio(rs.getInt("id_negocio"));
		return producto;
	}

}
