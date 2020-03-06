package cl.ttlan.restservices.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.ttlan.restservices.model.Usuario;


@RestController
@RequestMapping("/loguinLan")
@CrossOrigin
public class LoguinTtLan {
	
	@PostMapping
	public ResponseEntity<Usuario> loguinUsuario(@RequestBody Usuario usuario) {
		
			return new ResponseEntity<Usuario>(usuario, new HttpHeaders(), HttpStatus.OK);
	}

}
