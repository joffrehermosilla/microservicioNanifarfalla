package nanifarfalla.microservicios.app.examenes.services;



import org.springframework.stereotype.Service;

import nanifarfalla.microservicios.app.examenes.models.entity.Examen;
import nanifarfalla.microservicios.app.examenes.models.repository.ExamenRepository;
import nanifarfalla.microservicios.commons.services.CommonServiceImpl;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository>  implements ExamenService {

	
	
}
