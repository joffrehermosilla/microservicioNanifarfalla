package nanifarfalla.microservicios.app.respuestas.models.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import nanifarfalla.microservicios.app.respuestas.models.entity.Respuesta;

public interface RespuestaRepository extends MongoRepository<Respuesta, String> {

//	@Query("select r from Respuesta r join fetch r.alumno a join fetch r.pregunta p join fetch p.examen e where a.id=?1 and e.id=?2")
//	@Query("select r from Respuesta r join fetch r.pregunta p join fetch p.examen e where r.alumnoId=?1 and e.id=?2")
//public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId);

	// @Query("select e.id from Respuesta r join r.pregunta p join p.examen e where
	// r.alumnoId=?1 group by e.id")
	// public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);

	@Query("{'alumnoId': ?0, 'preguntaId':{$in: ?1} }")
	public Iterable<Respuesta> findRespuestaByAlumnoByPreguntasds(Long alumnoId, Iterable<Long> preguntaIds);

	
	
	
}
