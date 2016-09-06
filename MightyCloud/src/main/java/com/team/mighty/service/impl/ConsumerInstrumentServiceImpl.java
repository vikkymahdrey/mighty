package com.team.mighty.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.team.mighty.dao.MightyDeviceInfoDAO;
import com.team.mighty.domain.MightyDeviceInfo;
import com.team.mighty.dto.ConsumerDeviceDTO;
import com.team.mighty.exception.MightyAppException;
import com.team.mighty.service.ConsumerInstrumentService;

/**
 * 
 * @author Shankara
 *
 */
@Service("consumerInstrumentServiceImpl")
public class ConsumerInstrumentServiceImpl implements ConsumerInstrumentService {

	@Autowired
	private MightyDeviceInfoDAO mightyDeviceInfoDAO;
	
	public boolean userLogin() {
		// TODO Auto-generated method stub
		return false;
	}

	public void registerDevice(ConsumerDeviceDTO consumerDeviceDto) {
		// TODO Auto-generated method stub
		
	}

	public void deRegisterDevice(ConsumerDeviceDTO consumerDeviceDto) {
		// TODO Auto-generated method stub
		
	}

	public void updateReistrationToken() {
		// TODO Auto-generated method stub
		
	}

	public void retriveDevices() {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void validateDevice(String deviceId) throws MightyAppException {
		if(null == deviceId ||  "".equalsIgnoreCase(deviceId)) {
			throw new MightyAppException(" Device ID or Input is empty", HttpStatus.BAD_REQUEST);
		}
		
		MightyDeviceInfo mightyDeviceInfo = mightyDeviceInfoDAO.getDeviceInfo(deviceId);
		
		if(null == mightyDeviceInfo) {
			throw new MightyAppException(" Device Details not found", HttpStatus.NOT_FOUND);
		}
		
		String isActive = mightyDeviceInfo.getIsActive();
		
		if(null == isActive || isActive.equalsIgnoreCase("N")) {
			throw new MightyAppException(" Device is not active or status is empty", HttpStatus.GONE);
		}
		
		String isRegistered = mightyDeviceInfo.getIsRegistered();
		
		if(null != isRegistered && isRegistered.equalsIgnoreCase("Y")) {
			throw new MightyAppException(" Deivce already registered ", HttpStatus.CONFLICT);
		}
	}

	public MightyDeviceInfoDAO getMightyDeviceInfoDAO() {
		return mightyDeviceInfoDAO;
	}

	public void setMightyDeviceInfoDAO(MightyDeviceInfoDAO mightyDeviceInfoDAO) {
		this.mightyDeviceInfoDAO = mightyDeviceInfoDAO;
	}

}