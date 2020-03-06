package cl.ttlan.restservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ttlan.restservices.entity.UsuarioEntity;


public interface TtlanRepository extends JpaRepository<UsuarioEntity, Long>   {

}
