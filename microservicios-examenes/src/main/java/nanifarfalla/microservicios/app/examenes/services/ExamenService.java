package nanifarfalla.microservicios.app.examenes.services;

import java.util.List;

import nanifarfalla.microservicios.commons.examenes.models.entity.Asignatura;
import nanifarfalla.microservicios.commons.examenes.models.entity.Examen;
import nanifarfalla.microservicios.commons.services.CommonService;

public interface ExamenService extends CommonService<Examen> {

	public List<Examen> findByNombre(String term);
	
	public Iterable <Asignatura> findAllAsignaturas();
	
}
