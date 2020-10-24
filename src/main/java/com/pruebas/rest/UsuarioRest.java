package com.pruebas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.model.Usuario;
import com.pruebas.repository.UsuarioRespository;

@RestController
@RequestMapping("api/v1/usuario")
@CrossOrigin(origins = "*")
public class UsuarioRest {

	@Autowired
	UsuarioRespository usuarioRepository;

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable int id) {

		try {
			return new ResponseEntity<Usuario>(usuarioRepository.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return 	new ResponseEntity<Usuario>(usuarioRepository.getById(id), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public String save(@RequestBody Usuario usuario) {

		return usuarioRepository.save(usuario) ? "User Add" : "User Not Add";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<Usuario> authenticate(@RequestBody Usuario usuario) {

		try {

			ResponseEntity<Usuario> response = new ResponseEntity<Usuario>(
					usuarioRepository.getByEmailAndPassword(usuario.getEmail(), usuario.getPassword()), HttpStatus.ACCEPTED);
			if (response.getBody() != null) {
				return response;
			} else {
				return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity update(@RequestBody Usuario usuario) {
		
		boolean res = usuarioRepository.update(usuario);
		if(res)
			return new ResponseEntity(true,HttpStatus.OK);
		return new ResponseEntity(false, HttpStatus.NOT_MODIFIED);	
	}
	
}
