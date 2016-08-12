package com.team.mighty.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.team.mighty.constant.MightyConfigConstants;
import com.team.mighty.exception.MightyAppException;
import com.team.mighty.logger.MightyLogger;
import com.team.mighty.service.SpotifyAccessService;
import com.team.mighty.utils.JsonUtil;
import com.team.mighty.utils.SpringPropertiesUtil;
import com.team.mighty.utils.StringUtil;

@Component("spotifyAccessService")
public class SpotifyAccessServiceImpl implements SpotifyAccessService {

	private static final MightyLogger logger = MightyLogger.getLogger(SpotifyAccessServiceImpl.class);
	
	public String getAccessToken(String code, String error, String state) throws MightyAppException {
		String refreshToken = null;
		if(StringUtil.isEmpty(error)) {
			String url = SpringPropertiesUtil.getProperty(MightyConfigConstants.SPOTIFY_URL);
			String api = SpringPropertiesUtil.getProperty(MightyConfigConstants.ACCESS_TOKEN_API);
			
			String clientId = SpringPropertiesUtil.getProperty(MightyConfigConstants.SPOTIFY_CLIENT_ID);
			String clientSecret = SpringPropertiesUtil.getProperty(MightyConfigConstants.SPOTIFY_CLIENT_SECRET);
			
			String authorization = new String(Base64.encodeBase64((clientId+clientSecret).getBytes()));
			
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add(MightyConfigConstants.AUTHORIZATION_HEADER, "Basic "+authorization);
			httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			
			Map<String, String> requestMap = new HashMap<String, String>();
			requestMap.put(MightyConfigConstants.KEY_GRANT_TYPE, 
					SpringPropertiesUtil.getProperty(MightyConfigConstants.SPOTIFY_GRANT_TYPE));
			requestMap.put(MightyConfigConstants.KEY_CODE, code);
			requestMap.put(MightyConfigConstants.KEY_REDIRECT_URL, "http%3A%2F%2Flocalhost%3A8080%2FMightyCloud%2Fspotifyaccess");
			
			String request = JsonUtil.objToJson(requestMap);
			logger.info(" Request Json ", request);
			logger.info(" Header ", httpHeaders);
			
			HttpEntity<String> entity = new HttpEntity<String>(request,httpHeaders);
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(url+api, HttpMethod.POST, entity, String.class);
			
			logger.info(response);
		} else {
			throw new MightyAppException(error, HttpStatus.FORBIDDEN);
		}
			
		return null;
	}

}
