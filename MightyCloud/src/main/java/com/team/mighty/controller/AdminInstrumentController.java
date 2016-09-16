package com.team.mighty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team.mighty.constant.MightyAppConstants;
import com.team.mighty.dto.DeviceInfoDTO;
import com.team.mighty.exception.MightyAppException;
import com.team.mighty.logger.MightyLogger;
import com.team.mighty.service.AdminInstrumentService;
import com.team.mighty.utils.JsonUtil;

@RestController
@RequestMapping(MightyAppConstants.ADMIN_API)
public class AdminInstrumentController {

	private static final MightyLogger logger = MightyLogger.getLogger(AdminInstrumentController.class);
	
	@Autowired
	private AdminInstrumentService adminInstrumentServiceImpl;
	
	@RequestMapping(value = "/device", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllMightyDevices() {
		ResponseEntity<String> responseEntity = null;
		try {
			List<DeviceInfoDTO> lstMightyDeviceInfo = adminInstrumentServiceImpl.getAllMightyDevice();
			String response = JsonUtil.objToJson(lstMightyDeviceInfo);
			responseEntity = new ResponseEntity<String>(response, HttpStatus.OK);
			
		} catch(MightyAppException e) {
			logger.error(e);
			responseEntity = new ResponseEntity<String>(e.getMessage(), e.getHttpStatus());
		}
		return responseEntity;
	}
}
