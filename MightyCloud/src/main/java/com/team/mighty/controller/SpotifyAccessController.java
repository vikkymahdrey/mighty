package com.team.mighty.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.mighty.constant.MightyAppConstants;
import com.team.mighty.logger.MightyLogger;

@RestController(MightyAppConstants.SPOTIFY_API)
public class SpotifyAccessController {
	
	private static final MightyLogger logger = MightyLogger.getLogger(SpotifyAccessController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getSpotifyClientCode(@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "state", required = false) String state) {
		logger.info(" Code", code , "Error ", error, "State", state);
		return null;
	}
}
