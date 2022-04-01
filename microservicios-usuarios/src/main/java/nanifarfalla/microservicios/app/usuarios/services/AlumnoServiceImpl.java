package nanifarfalla.microservicios.app.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nanifarfalla.microservicios.app.usuarios.client.CursoFeignClient;
import nanifarfalla.microservicios.app.usuarios.models.repository.AlumnoRepository;
import nanifarfalla.microservicios.commons.alumnos.models.entity.Alumno;
import nanifarfalla.microservicios.commons.services.CommonServiceImpl;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

	@Autowired
	private CursoFeignClient clientCurso;

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {
		// TODO Auto-generated method stub
		return repository.findByNombreOrApellido(term);
	}

	@Override
	public int lastcode() {
		return repository.lastcode();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAllById(Iterable<Long> Ids) {

		return repository.findAllById(Ids);
	}

	@Override
	public void eliminarCursoAlumnoPorId(Long id) {
		clientCurso.eliminarCursoAlumnoPorId(id);

	}

	@Override
	@Transactional
	public void deleteById(Long id) {

		super.deleteById(id);
		this.eliminarCursoAlumnoPorId(id);

	}

}
