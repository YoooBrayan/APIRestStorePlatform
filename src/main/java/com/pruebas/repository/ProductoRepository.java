package com.pruebas.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pruebas.mapper.ProductoMapper;
import com.pruebas.model.Producto;

@Repository
public class ProductoRepository implements IProducto {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbc;

	@PostConstruct
	public void PostConstruct() {
		jdbc = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean save(Producto producto) {

		try {
			String sql = String.format(
					"insert into producto(nombre, descripcion, tipo, cantidad, valor, foto, id_negocio) values ('%s', '%s', '%d', '%d', '%d', '%s', '%d')",
					producto.getNombre(), producto.getDescripcion(), producto.getTipo(), producto.getCantidad(),
					producto.getValor(), producto.getFoto(), producto.getId_negocio());
			jdbc.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Producto getById(int id) {

		return null;
	}

	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getAll(int id_negocio) {

		try {

			return jdbc.query("select * from producto where id_negocio = ?", new Object[] { id_negocio },
					new ProductoMapper());

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean update(Producto object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
