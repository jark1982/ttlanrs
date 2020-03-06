package cl.ttlan.restservices.services;

import java.net.URI;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.ttlan.restservices.entity.UsuarioEntity;
import cl.ttlan.restservices.model.Usuario;
import cl.ttlan.restservices.repository.TtlanRepository;

@Service
public class TtlanServices {
	@Autowired
	TtlanRepository ttlanRepository;

	public Usuario createOrUpdateUsuario(Usuario usuario) {
		UsuarioEntity newEntity = new UsuarioEntity();
		long millis = System.currentTimeMillis();
		newEntity.setUsuario(usuario.getUsername());
		newEntity.setLastLogin(new Date(millis));
		newEntity.setPassword(usuario.getPassword());
		newEntity = ttlanRepository.save(newEntity);
		return usuario;
	}

	public Usuario loguinUsuarioService(Usuario usuario) {

		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "https://www.ficcion.cl/ws/api/login";
		URI uri;
		try {
			uri = new URI(baseUrl);
			restTemplate.postForEntity(uri, usuario, String.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		} finally {
			ResponseEntity.status(HttpStatus.OK);
			createOrUpdateUsuario(usuario);
		}
		return usuario;
	}
}
