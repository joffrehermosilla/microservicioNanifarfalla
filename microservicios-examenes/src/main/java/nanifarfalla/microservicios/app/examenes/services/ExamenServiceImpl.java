package nanifarfalla.microservicios.app.examenes.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nanifarfalla.microservicios.app.examenes.models.repository.AsignaturaRepository;
import nanifarfalla.microservicios.app.examenes.models.repository.ExamenRepository;
import nanifarfalla.microservicios.commons.examenes.models.entity.Asignatura;
import nanifarfalla.microservicios.commons.examenes.models.entity.Examen;
import nanifarfalla.microservicios.commons.services.CommonServiceImpl;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository>  implements ExamenService {

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term) {
		
		return repository.findByNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable <Asignatura> findAllAsignaturas() {
		
		return  asignaturaRepository.findAll();
	}

	
	
}
