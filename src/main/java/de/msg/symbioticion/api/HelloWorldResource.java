package de.msg.symbioticion.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.client.ApiException;
import io.swagger.client.api.ProviderApi;
import io.swagger.client.model.Provider;

@Controller
public class HelloWorldResource {

	/**
	 * Just a simple test to see if the service is up. Says hi.
	 * 
	 * @param String
	 *            The name of the person to greet.
	 * @return String a greeting.
	 * @throws ApiException
	 */
	@RequestMapping(value = "/api/ahoi/providers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Provider>> providers() throws ApiException {

		List<Provider> providers = new ProviderApi().getProviders(null, null, null);
		return ResponseEntity.ok(providers);
	}

}
