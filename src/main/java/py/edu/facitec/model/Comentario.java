package py.edu.facitec.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comentario extends General{
	 
	 private String texto;
	 private Integer estrellas;
	 
	 // MUCHOS A UNO	
	 @ManyToOne
	 // ACCESO	CLASE	OBJETO
	 private 	Post 	post;
	 
	 @JsonBackReference(value = "post-comentario")
	 @ManyToOne
	 private Suscrito suscrito;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(Integer estrellas) {
		this.estrellas = estrellas;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comentario [texto=" + texto + ", estrellas=" + estrellas + "]";
	}
	 
}
