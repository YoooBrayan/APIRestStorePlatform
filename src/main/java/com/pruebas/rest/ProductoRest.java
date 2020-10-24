package com.pruebas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.model.Producto;
import com.pruebas.repository.ProductoRepository;

@RestController
@RequestMapping("/api/v1/producto")
@CrossOrigin(origins = "*")
public class ProductoRest {


	@Autowired
	private ProductoRepository productoRepository;
	
	@PostMapping
	public ResponseEntity save(@RequestBody Producto producto) {
		boolean res = productoRepository.save(producto);
		if(res)
			return new ResponseEntity(true, HttpStatus.CREATED);
		return new ResponseEntity(false, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Producto>> getAll(@PathVariable int id){
		List products = productoRepository.getAll(id);
		if(!products.isEmpty())
			return new ResponseEntity<List<Producto>>(products, HttpStatus.OK);
		return new ResponseEntity<List<Producto>>(products, HttpStatus.NOT_FOUND);
	}
	
}
