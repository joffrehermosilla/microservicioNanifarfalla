package nanifarfalla.microservicios.commons.alumnos.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "alumno")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotEmpty
	@Email
	private String email;

	@Column(name ="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creatAt;

	@Lob
	@JsonIgnore
	private byte[]foto;
	
	@JsonIgnore
	private String rutafoto;
	
	
	@PrePersist
	public void prePersist() {
		this.creatAt = new Date();
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatAt() {
		return creatAt;
	}

	public void setCreatAt(Date creatAt) {
		this.creatAt = creatAt;
	}



	@Override
	public boolean equals(Object obj) {

		if(this == obj) {
			return true;
		}
		
		if (!(obj instanceof Alumno)) {
			return false;
		}
		
		Alumno a = (Alumno) obj;
		
		
		return this.id != null && this.id.equals(a.getId());
	}



	public byte[] getFoto() {
		return foto;
	}



	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	
	public Integer getFotoHashCode() {
		return (this.foto !=null)? this.foto.hashCode():null;
	}



	public String getRutafoto() {
		return rutafoto;
	}



	public void setRutafoto(String rutafoto) {
		this.rutafoto = rutafoto;
	}
	
	
}
