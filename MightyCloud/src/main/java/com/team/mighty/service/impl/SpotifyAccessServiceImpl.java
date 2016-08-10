package com.team.mighty.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.team.mighty.constant.MightyConfigConstants;
import com.team.mighty.exception.MightyAppException;
import com.team.mighty.service.SpotifyAccessService;
import com.team.mighty.utils.SpringPropertiesUtil;
import com.team.mighty.utils.StringUtil;

@Component("spotifyAccessService")
public class SpotifyAccessServiceImpl implements SpotifyAccessService {

	public String getAccessToken(String code, String error, String state) throws MightyAppException {
		String refreshToken = null;
		if(StringUtil.isEmpty(error)) {
			String url = SpringPropertiesUtil.getProperty(MightyConfigConstants.SPOTIFY_URL);
			String api = SpringPropertiesUtil.getProperty(MightyConfigConstants.ACCESS_TOKEN_API);
			
			String clientId = SpringPropertiesUtil.getProperty(MightyConfigConstants.SPOTIFY_CLIENT_ID);
			String clientSecret = SpringPropertiesUtil.getProperty(MightyConfigConstants.SPOTIFY_CLIENT_SECRET);
			
			String authorization = new String(Base64.decodeBase64(clientId+clientSecret));
			
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add(MightyConfigConstants.AUTHORIZATION_HEADER, "Basic "+authorization);
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			Map<String, String> requestMap = new HashMap<String, String>();
			requestMap.put(MightyConfigConstants.KEY_GRANT_TYPE, 
					SpringPropertiesUtil.getProperty(MightyConfigConstants.SPOTIFY_GRANT_TYPE));
			requestMap.put(MightyConfigConstants.KEY_CODE, code);
			requestMap.put(MightyConfigConstants.KEY_REDIRECT_URL, "http://localhost:8080/MightyCloud/spotifyaccess");
			
			
			RestTemplate restTemplate = new RestTemplate();
			//restTemplate.postForObject(url+api, request, responseType, uriVariables);
		} else {
			throw new MightyAppException(error, HttpStatus.FORBIDDEN);
		}
			
		return null;
	}

}
