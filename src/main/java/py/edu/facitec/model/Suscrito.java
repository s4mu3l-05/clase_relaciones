package py.edu.facitec.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//crear la tabla

 @Entity
 
public class Suscrito {

	//PK GEN AUT, tradicional
	 
	 @Id
	 @GeneratedValue
	private Long codigo;
	private String nombre;
	private String correo;
	
	@JsonIgnore // IGNORA LA LISTA CUANDO EL OBJETO SUSCRITO ES + IMPORTANTE
	@OneToMany(mappedBy = "suscrito")
	private List<Comentario> comentarios;
	
	//GETTERS AND SETTERS
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Suscrito [codigo=" + codigo + ", nombre=" + nombre + ", correo=" + correo + ", comentarios="
				+ comentarios + "]";
	}
	
	
}
