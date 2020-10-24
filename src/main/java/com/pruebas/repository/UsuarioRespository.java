package com.pruebas.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pruebas.mapper.UsuarioMapper;
import com.pruebas.model.Usuario;

@Repository
public class UsuarioRespository implements IUsuario {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbc;

	@PostConstruct
	public void postConstruct() {
		this.jdbc = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean save(Usuario usuario) {

		try {
			String sql = String.format(
					"insert into usuario(nombre, nit, tipo_documento, numero_documento, email, password) values ('%s', '%d', '%d', '%s', '%s', sha1('%s'))",
					usuario.getNombre(), usuario.getNit(), usuario.getTipo_documento(), usuario.getNumero_documento(),
					usuario.getEmail(), usuario.getNumero_documento());
			jdbc.execute(sql);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}	

	@Override
	public Usuario getById(int id) {

		try {
			Object[] params = new Object[] { id };
			return jdbc.queryForObject("select * from usuario where id = ?", params, new UsuarioMapper());
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Usuario> getAll() {

		return null;
	}

	@Override
	public boolean update(Usuario usuario) {

		try {
			String sql = String.format("update usuario set nombre = '%s', nit = '%s', email = '%s' where id = '%d'", usuario.getNombre(), usuario.getNit(), usuario.getEmail(), usuario.getId()	);
			jdbc.execute(sql);
			return true;
		} catch (Exception e) {
			System.out.println(e);	
			return false;
		}

	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario getByEmailAndPassword(String email, String password) {

		System.out.println(email + " " + password);
		try {
			Object[] params = new Object[] { email, password };
			return jdbc.queryForObject("select id, nombre, nit, tipo_documento, numero_documento, email from usuario where email = ? and password = sha1(?)", params,
					new UsuarioMapper());

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

}
