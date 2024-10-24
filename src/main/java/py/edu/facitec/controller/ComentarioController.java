package py.edu.facitec.controller;

import java.awt.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Comentario;
import py.edu.facitec.repository.ComentorioRepository;

@RestController
@RequestMapping("api")
public class ComentarioController {

	@Autowired
	private ComentorioRepository comentarioRepository;
		
		@GetMapping("/comentarios")
		public ResponseEntity<java.util.List<Comentario>> getComentario() {
			
			java.util.List<Comentario> comentarios = comentarioRepository.findAll();
			
			
			return new ResponseEntity<java.util.List<Comentario>>(comentarios, HttpStatus.OK);	
		}
		
		
		@PostMapping("/comentario")
		public ResponseEntity<Comentario> guardarComentario(@RequestBody Comentario comentario){
			
			comentarioRepository.save(comentario);
			
			return new ResponseEntity<Comentario>(comentario, HttpStatus.OK);	 
		}
		
		@GetMapping("/comentario/{id}")
		public ResponseEntity<Comentario> getOneComentario(@PathVariable Long id) {
			Optional<Comentario> comRetorno = comentarioRepository.findById(id);
			
			if (comRetorno.isPresent()) {
				return new ResponseEntity<Comentario>(comRetorno.get(), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
		}
		
		
		
		@DeleteMapping("/comentario/{id}")
		public ResponseEntity<Comentario> removeOneComentario(@PathVariable Long id) {

			Optional<Comentario> comRetorno = comentarioRepository.findById(id);
			// si encuentra
			if (comRetorno.isPresent()) {

				comentarioRepository.deleteById(id);

				return new ResponseEntity<>(HttpStatus.OK);

			} else { // si no se encuentra por la id

				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			}

		}
}
