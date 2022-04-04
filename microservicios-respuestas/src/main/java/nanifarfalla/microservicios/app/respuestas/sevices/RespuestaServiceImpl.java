package nanifarfalla.microservicios.app.respuestas.sevices;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.microservicios.app.respuestas.clients.ExamenFeignClient;
import nanifarfalla.microservicios.app.respuestas.models.entity.Respuesta;
import nanifarfalla.microservicios.app.respuestas.models.repository.RespuestaRepository;
import nanifarfalla.microservicios.commons.examenes.models.entity.Examen;
import nanifarfalla.microservicios.commons.examenes.models.entity.Pregunta;

@Service
public class RespuestaServiceImpl implements RespuestaService {

	@Autowired
	private RespuestaRepository repository;

	@Autowired
	private ExamenFeignClient examenClient;

	@Override
	// @Transactional
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {

		return repository.saveAll(respuestas);
	}

	@Override
	// @Transactional(readOnly = true)
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId) {
		Examen examen = examenClient.obtenerExamenPorId(examenId);

		List<Pregunta> preguntas = examen.getPreguntas();
		List<Long> preguntaIds = preguntas.stream().map(p -> p.getId()).collect(Collectors.toList());
		List<Respuesta> respuestas = (List<Respuesta>) repository.findRespuestaByAlumnoByPreguntasds(alumnoId,
				preguntaIds);
		respuestas = respuestas.stream().map(r -> {
			preguntas.forEach(p -> {
				if (p.getId() == r.getPreguntaId()) {
					r.setPregunta(p);
				}
			});
			return r;
		}).collect(Collectors.toList());

		return respuestas;
	}

	@Override
	// @Transactional(readOnly = true)
	public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId) {
		return null;
	}

}
