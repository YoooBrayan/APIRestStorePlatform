package com.pruebas.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pruebas.mapper.NegocioMapper;
import com.pruebas.model.Negocio;

@Repository
public class NegocioRepository implements INegocio {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbc;

	@PostConstruct
	public void postConstruct() {
		jdbc = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean save(Negocio negocio) {

		try {
			String sql = String.format(
					"insert into negocio(nombre, foto, id_encargado, tipo) values ('%s', '%s', '%d', '%d')",
					negocio.getNombre(), negocio.getFoto(), negocio.getId_encargado(), negocio.getTipo());
			jdbc.execute(sql);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Negocio getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Negocio> getAll() {

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean update(Negocio object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Negocio> getAll(int id_encargado) {

		try {
			return jdbc.query("select * from negocio where id_encargado = ?", new Object[] { id_encargado },
					new NegocioMapper());

		} catch (Exception e) {
			return null;
		}

	}

}
