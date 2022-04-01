package nanifarfalla.microservicios.app.cursos.services;

import java.util.List;

import nanifarfalla.microservicios.app.cursos.models.entity.Curso;
import nanifarfalla.microservicios.commons.alumnos.models.entity.Alumno;
import nanifarfalla.microservicios.commons.services.CommonService;

public interface CursoService extends CommonService<Curso> {
	public Curso findCursoByALumnoId(Long id);

	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId);

	public Iterable<Alumno> obtenerAlumnosPorCurso(List<Long> ids);

	public void eliminarCursoAlumnoPorId(Long id);
}
