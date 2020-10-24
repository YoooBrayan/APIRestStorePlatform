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

import com.pruebas.model.Negocio;
import com.pruebas.repository.NegocioRepository;

@RestController
@RequestMapping("api/v1/negocio")
@CrossOrigin(origins = "*")
public class NegocioRest {

	@Autowired
	private NegocioRepository negocioRespository;

	@PostMapping
	public ResponseEntity save(@RequestBody Negocio negocio) {

		boolean res;
		res = negocioRespository.save(negocio);
		if (res)
			return new ResponseEntity(true, HttpStatus.CREATED);
		return new ResponseEntity(false, HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("/negocios/{id}")
	public ResponseEntity<List<Negocio>> getAll(@PathVariable int id) {
		
		List negocios = negocioRespository.getAll(id);
		return new ResponseEntity<List<Negocio>>(negocios, !negocios.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT);

	}
}
