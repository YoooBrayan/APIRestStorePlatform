package com.pruebas.repository;

import java.util.List;

public interface BaseRepository<T> {


	public boolean save(T object);
	
	public T getById(int id);
	
	public List<T> getAll();
	
	public boolean update(T object);
	
	public boolean delete(int id);
	
}
