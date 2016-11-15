package de.msg.symbioticion.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AhoiResource {

	/**
	 * Just a simple test to see if the service is up. Says hi.
	 * 
	 * @param String
	 *            The name of the person to greet.
	 * @return String a greeting.
	 */
	@RequestMapping(value = "/api/hello", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> sayHello(@RequestParam(value = "name", required = false) String name) {
		if (name == null)
			return ResponseEntity.badRequest().body("I need someone to say hi to. Use ?name= ...");
		return ResponseEntity.ok("Hallo " + name);
	}

}
