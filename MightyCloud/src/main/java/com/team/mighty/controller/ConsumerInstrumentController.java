package com.team.mighty.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team.mighty.constant.MightyAppConstants;
import com.team.mighty.domain.MightyDeviceInfo;
import com.team.mighty.exception.MightyAppException;
import com.team.mighty.logger.MightyLogger;

/**
 * 
 * @author Shankara
 *
 */

@RestController(MightyAppConstants.CONSUMER_API)
public class ConsumerInstrumentController {
	
	private static final MightyLogger logger = MightyLogger.getLogger(ConsumerInstrumentController.class);

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String sayHello() {
		return "Hell world Shankar";
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> doRegistration(@RequestBody MightyDeviceInfo mightDeviceInfo) {
		logger.info(" /POST Consumer API",  mightDeviceInfo);
		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<String>(HttpStatus.OK);
		} catch(MightyAppException e) {
			responseEntity = new ResponseEntity<String>(e.getHttpStatus());
		}
		return responseEntity;
	}
}
	