package nanifarfalla.microservicios.app.usuarios.services;

import java.util.Optional;

import nanifarfalla.microservicios.app.usuarios.models.entity.Alumno;

public interface AlumnoService {

	
	public Iterable<Alumno> findAll();
	
	public Optional<Alumno> findById(Long Id);
	
	public Alumno save (Alumno alumno);
	
	public void deleteById(Long id);
	
	
	
	
}
