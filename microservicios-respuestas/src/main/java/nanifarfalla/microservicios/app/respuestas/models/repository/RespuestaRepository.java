package nanifarfalla.microservicios.app.respuestas.models.repository;

import org.springframework.data.repository.CrudRepository;

import nanifarfalla.microservicios.app.respuestas.models.entity.Respuesta;

public interface RespuestaRepository extends CrudRepository<Respuesta, Long>{

}
