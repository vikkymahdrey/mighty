package com.team.mighty.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.team.mighty.dao.MightyDeviceInfoDAO;
import com.team.mighty.domain.MightyDeviceInfo;
import com.team.mighty.dto.ConsumerDeviceDTO;
import com.team.mighty.exception.MightyAppException;
import com.team.mighty.logger.MightyLogger;
import com.team.mighty.service.ConsumerInstrumentService;

/**
 * 
 * @author Shankara
 *
 */
@Service("consumerInstrumentServiceImpl")
public class ConsumerInstrumentServiceImpl implements ConsumerInstrumentService {

	private final MightyLogger logger = MightyLogger.getLogger(ConsumerInstrumentServiceImpl.class);
	
	@Autowired
	private MightyDeviceInfoDAO mightyDeviceInfoDAO;
	
	public boolean userLogin() {
		// TODO Auto-generated method stub
		return false;
	}

	public void registerDevice(ConsumerDeviceDTO consumerDeviceDto) throws MightyAppException {
		if(null == consumerDeviceDto) {
			logger.debug("Register Device, Consumer Device DTO object is null");
			throw new MightyAppException("Invalid request Object", HttpStatus.BAD_REQUEST);
		}
		
		if((null == consumerDeviceDto.getUserName() || "".equalsIgnoreCase(consumerDeviceDto.getUserName()))
				|| (null == consumerDeviceDto.getDeviceId() || "".equals(consumerDeviceDto.getDeviceId()))
				|| (null == consumerDeviceDto.getMightyDeviceId() || "".equals(consumerDeviceDto.getMightyDeviceId()))) {
			logger.debug("Register Device, Anyone of the object is empty [UserName, DeviceId, MightyDeviceId] ", consumerDeviceDto.getUserName(), 
					",",consumerDeviceDto.getDeviceId(), ",",consumerDeviceDto.getMightyDeviceId() );
			throw new MightyAppException("Invalid request Parameters [UserName or Device Id or Mighty Device Id] ", HttpStatus.BAD_REQUEST);
		}
		
		validateDevice(consumerDeviceDto.getMightyDeviceId());
	}

	public void deRegisterDevice(ConsumerDeviceDTO consumerDeviceDto) {
		if(null == consumerDeviceDto) {
			logger.debug("De Register Device, Consumer Device DTO object is null");
			throw new MightyAppException("Invalid request Object", HttpStatus.BAD_REQUEST);
		}
		
		if((null == consumerDeviceDto.getUserName() || "".equalsIgnoreCase(consumerDeviceDto.getUserName()))
				|| (null == consumerDeviceDto.getDeviceId() || "".equals(consumerDeviceDto.getDeviceId()))
				|| (null == consumerDeviceDto.getMightyDeviceId() || "".equals(consumerDeviceDto.getMightyDeviceId()))) {
			logger.debug(" De RegisterDevice, Anyone of the object is empty [UserName, DeviceId, MightyDeviceId] ", consumerDeviceDto.getUserName(), 
					",",consumerDeviceDto.getDeviceId(), ",",consumerDeviceDto.getMightyDeviceId() );
			throw new MightyAppException("Invalid request Parameters [UserName or Device Id or Mighty Device Id] ", HttpStatus.BAD_REQUEST);
		}
		
	}

	public void updateReistrationToken() {
		// TODO Auto-generated method stub
		
	}

	public void retriveDevices() {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void validateDevice(String deviceId) throws MightyAppException {
		logger.info(" === ConsumerInstrumentServiceImpl, ValidateDevice, Device Id ", deviceId);
		if(null == deviceId ||  "".equalsIgnoreCase(deviceId)) {
			throw new MightyAppException(" Device ID or Input is empty", HttpStatus.BAD_REQUEST);
		}
		
		MightyDeviceInfo mightyDeviceInfo = null;
		try {
			mightyDeviceInfo = mightyDeviceInfoDAO.getDeviceInfo(deviceId);
		} catch(Exception e) {
			throw new MightyAppException("System Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
		}
		
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