package com.team.mighty.service;

import java.util.List;

import com.team.mighty.domain.MightyDeviceFirmware;
import com.team.mighty.domain.MightyDeviceInfo;
import com.team.mighty.domain.MightyUserInfo;
import com.team.mighty.dto.ConsumerDeviceDTO;
import com.team.mighty.dto.UserLoginDTO;
import com.team.mighty.exception.MightyAppException;

/**
 * 
 * @author Shankara
 *
 */
public interface ConsumerInstrumentService {
	
	public void validateDevice(String deviceId) throws MightyAppException; 
	
	public UserLoginDTO userLogin(UserLoginDTO userLoginDTO) throws MightyAppException;
	
	public void registerDevice(ConsumerDeviceDTO consumerDeviceDto) throws MightyAppException;
	
	public void deRegisterDevice(ConsumerDeviceDTO consumerDeviceDto);
	
	public void deregisterDevice(String deviceId);
	
	public void updateReistrationToken();
	
	public void retriveDevices();
	
	public List<MightyUserInfo> getMightyUserInfo() throws Exception;

	public List<MightyDeviceInfo> getMightyDeviceInfo() throws Exception;

	

}
