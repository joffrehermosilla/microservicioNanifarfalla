package nanifarfalla.microservicios.app.cursos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nanifarfalla.microservicios.app.cursos.controllers.clients.AlumnoFeignClient;
import nanifarfalla.microservicios.app.cursos.controllers.clients.RespuestaFeignClient;
import nanifarfalla.microservicios.app.cursos.models.entity.Curso;
import nanifarfalla.microservicios.app.cursos.models.repository.CursoRepository;
import nanifarfalla.microservicios.commons.alumnos.models.entity.Alumno;
import nanifarfalla.microservicios.commons.services.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Autowired
	private RespuestaFeignClient client;

	@Autowired
	private AlumnoFeignClient clientAlumno;

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByALumnoId(Long id) {

		return repository.findCursoByALumnoId(id);
	}

	@Override
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId) {

		return client.obtenerExamenesIdsConRespuestasAlumno(alumnoId);
	}

	@Override
	public Iterable<Alumno> obtenerAlumnosPorCurso(List<Long> ids) {

		return clientAlumno.obtenerAlumnosPorCurso(ids);
	}

	@Override
	@Transactional
	public void eliminarCursoAlumnoPorId(Long id) {

		repository.eliminarCursoAlumnoPorId(id);
		
	}

}
