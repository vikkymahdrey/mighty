package com.team.mighty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team.mighty.constant.MightyAppConstants;
import com.team.mighty.dto.ConsumerDeviceDTO;
import com.team.mighty.exception.MightyAppException;
import com.team.mighty.logger.MightyLogger;
import com.team.mighty.service.ConsumerInstrumentService;

/**
 * 
 * @author Shankara
 *
 */

@RestController
@RequestMapping(MightyAppConstants.CONSUMER_API)
public class ConsumerInstrumentController {
	
	@Autowired
	private ConsumerInstrumentService consumerInstrumentServiceImpl;
	
	private static final MightyLogger logger = MightyLogger.getLogger(ConsumerInstrumentController.class);

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> doRegistration(@RequestBody ConsumerDeviceDTO consumerDeviceDto) {
		logger.info(" /POST Consumer API",  consumerDeviceDto);
		ResponseEntity<String> responseEntity = null;
		try {
			consumerInstrumentServiceImpl.registerDevice(consumerDeviceDto);
			responseEntity = new ResponseEntity<String>(HttpStatus.OK);
		} catch(MightyAppException e) {
			responseEntity = new ResponseEntity<String>(e.getHttpStatus());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/{deviceId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> validateDevice(@PathVariable String deviceId) {
		logger.info("/GET Validate Devoce", deviceId);
		ResponseEntity<String> responseEntity = null;
		try {
			consumerInstrumentServiceImpl.validateDevice(deviceId);
			responseEntity = new ResponseEntity<String>(HttpStatus.OK);
		} catch(MightyAppException e) {
			responseEntity = new ResponseEntity<String>(e.getHttpStatus());
		}
		
		return responseEntity;
	}

	public ConsumerInstrumentService getConsumerInstrumentServiceImpl() {
		return consumerInstrumentServiceImpl;
	}

	public void setConsumerInstrumentServiceImpl(ConsumerInstrumentService consumerInstrumentServiceImpl) {
		this.consumerInstrumentServiceImpl = consumerInstrumentServiceImpl;
	}
}
	