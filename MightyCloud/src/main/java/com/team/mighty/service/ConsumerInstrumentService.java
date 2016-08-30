package com.team.mighty.service;

import com.team.mighty.domain.MightyDeviceInfo;
import com.team.mighty.dto.ConsumerDeviceDTO;

/**
 * 
 * @author Shankara
 *
 */
public interface ConsumerInstrumentService {
	
	public boolean validateDevice(MightyDeviceInfo mightyDeviceInfo); 
	
	public boolean userLogin();
	
	public void registerDevice(ConsumerDeviceDTO consumerDeviceDto);
	
	public void deRegisterDevice(ConsumerDeviceDTO consumerDeviceDto);
	
	public void updateReistrationToken();
	
	public void retriveDevices();
	

}
