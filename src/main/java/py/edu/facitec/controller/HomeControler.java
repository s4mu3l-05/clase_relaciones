package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Clase responsable a atender solicitudes
@Controller
public class HomeControler {

	//Sirve para atender una solicitud (request)
		@RequestMapping("/home") //post get ...
		
			public String index() {
				
		
				//static se buscan los archivos del cliente
				//por defecto
				
				//static the default client files are searched
				
				// response
			//application.properties
			//arhivo			.html
				return "/index";
	}
}