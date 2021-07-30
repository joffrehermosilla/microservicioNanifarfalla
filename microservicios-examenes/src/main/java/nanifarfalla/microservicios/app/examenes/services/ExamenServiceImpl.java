package nanifarfalla.microservicios.app.examenes.services;



import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nanifarfalla.microservicios.app.examenes.models.repository.ExamenRepository;
import nanifarfalla.microservicios.commons.examenes.models.entity.Examen;
import nanifarfalla.microservicios.commons.services.CommonServiceImpl;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository>  implements ExamenService {

	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term) {
		
		return repository.findByNombre(term);
	}

	
	
}
