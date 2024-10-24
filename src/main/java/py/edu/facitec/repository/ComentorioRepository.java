package py.edu.facitec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.facitec.model.Comentario;
import py.edu.facitec.model.Suscrito;


public interface ComentorioRepository extends JpaRepository<Comentario, Long>{

}
