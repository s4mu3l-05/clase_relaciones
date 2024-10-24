package py.edu.facitec.controller;

import java.util.List;
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

import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;

// Soporta la arquitectura Rest
// PARA SOLICITUDES EN FORMATO JSON
@RestController
@RequestMapping("api")
public class SuscritoController {

	@Autowired // :)
	private SuscritoRepository suscritoRepository;

	@GetMapping("/suscritos")
	// OBJETO SUSCRITO ------> JSON
	public ResponseEntity<List<Suscrito>> getSuscritos() {

		List<Suscrito> suscritos = suscritoRepository.findAll();

		return new ResponseEntity<List<Suscrito>>(suscritos, HttpStatus.OK);

	}

	@PostMapping("/suscrito")
	public ResponseEntity<Suscrito>
//					JSON--->JAVA
			guardarSuscrito(@RequestBody Suscrito suscrito) {
		suscritoRepository.save(suscrito);
		return new ResponseEntity<Suscrito>(suscrito, HttpStatus.OK);

	}

	@GetMapping("/suscrito/{id}")
	public ResponseEntity<Suscrito> 
		getOneSuscrito(@PathVariable Long id){
		
		Optional<Suscrito> susRetorno = suscritoRepository.findById(id);
		
		if (susRetorno.isPresent()) {
			return new ResponseEntity<Suscrito> (susRetorno.get(),HttpStatus.OK);
			
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
		}
	}
	
// OBTNER EL ID DEL PARAMETRO

	@DeleteMapping("/suscrito/{id}")
	public ResponseEntity<Suscrito> 
		removeOneSuscrito(@PathVariable Long id){
		
		Optional<Suscrito> susRetorno = suscritoRepository.findById(id);
		
		if (susRetorno.isPresent()) {
			suscritoRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}else{// SI NO SE ENCUENTRA
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
		}
	}
}
