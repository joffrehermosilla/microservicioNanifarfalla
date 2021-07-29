package nanifarfalla.microservicios.app.cursos.services;

import nanifarfalla.microservicios.app.cursos.models.entity.Curso;
import nanifarfalla.microservicios.commons.services.CommonService;

public interface CursoService extends CommonService<Curso> {
	  public Curso findCursoByALumnoId(Long id);
}
