package nanifarfalla.microservicios.app.usuarios.models.repository;

import org.springframework.data.repository.CrudRepository;

import nanifarfalla.microservicios.app.usuarios.models.entity.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}
