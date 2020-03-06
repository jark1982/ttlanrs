package cl.ttlan.restservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.ttlan.restservices.model.Usuario;
import cl.ttlan.restservices.services.TtlanServices;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/loguinLan")
@CrossOrigin
public class LoguinTtLan {

	@Autowired
	TtlanServices ttlanServices;

	@PostMapping
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Something went wrong"),
			@ApiResponse(code = 401, message = "Invalid JWT Token"),
			@ApiResponse(code = 404, message = "Account not Found"), @ApiResponse(code = 200, message = "Success") })

	public ResponseEntity<Usuario> loguinUsuario(@RequestBody Usuario usuario) {
		ttlanServices.loguinUsuarioService(usuario);
		return new ResponseEntity<Usuario>(usuario, new HttpHeaders(), HttpStatus.OK);
	}

}
