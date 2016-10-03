package com.team.mighty.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.team.mighty.constant.MightyAppConstants;
import com.team.mighty.dao.ConsumerInstrumentDAO;
import com.team.mighty.dao.MightyDeviceInfoDAO;
import com.team.mighty.dao.MightyDeviceUserMapDAO;
import com.team.mighty.domain.MightyDeviceInfo;
import com.team.mighty.domain.MightyDeviceUserMapping;
import com.team.mighty.domain.MightyUserInfo;
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
	
	@Autowired
	private ConsumerInstrumentDAO consumerInstrumentDAO;
	
	@Autowired
	private MightyDeviceUserMapDAO mightyDeviceUserMapDAO;
	

	public boolean userLogin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	private void registerUserAndDevice(ConsumerDeviceDTO consumerDeviceDto, MightyDeviceInfo mightyDeviceInfo) throws MightyAppException {
		
		MightyUserInfo mightyUserInfo = new MightyUserInfo();
		mightyUserInfo.setUserName(consumerDeviceDto.getUserName());
		mightyUserInfo.setUserStatus(MightyAppConstants.IND_A);
		mightyUserInfo.setFirstName(consumerDeviceDto.getFirstName());
		mightyUserInfo.setLastName(consumerDeviceDto.getLastName());
		mightyUserInfo.setEmailId(consumerDeviceDto.getEmailId());
		
		MightyDeviceUserMapping mightyDeviceUserMapping = new MightyDeviceUserMapping();
		mightyDeviceUserMapping.setMightyDeviceId(mightyDeviceInfo.getId());
		mightyDeviceUserMapping.setMightyUserInfo(mightyUserInfo);
		mightyDeviceUserMapping.setPhoneDeviceOSVersion(consumerDeviceDto.getDeviceOs());
		mightyDeviceUserMapping.setPhoneDeviceType(consumerDeviceDto.getDeviceType());
		mightyDeviceUserMapping.setPhoneDeviceId(consumerDeviceDto.getDeviceId());
		mightyDeviceUserMapping.setPhoneDeviceVersion(consumerDeviceDto.getDeviceOsVersion());
		
		Set<MightyUserInfo> setUserInfo = new HashSet<MightyUserInfo>();
		
		Set<MightyDeviceUserMapping> setMightyUserDevice = mightyUserInfo.getMightyDeviceUserMapping();
		if(setMightyUserDevice == null || mightyUserInfo.getMightyDeviceUserMapping().isEmpty()) {
			setMightyUserDevice = new HashSet<MightyDeviceUserMapping>();
		}
		setMightyUserDevice.add(mightyDeviceUserMapping);
		mightyUserInfo.setMightyDeviceUserMapping(setMightyUserDevice);
		
		mightyUserInfo.setMightyDeviceInfo(mightyDeviceInfo);
		
		setUserInfo.add(mightyUserInfo);
		
		mightyDeviceInfo.setIsRegistered(MightyAppConstants.IND_Y);
		mightyDeviceInfo.setMightyUserInfo(setUserInfo);
		
		try {
			consumerInstrumentDAO.save(mightyUserInfo);
		} catch(Exception e) {
			logger.error(e.getMessage());
			throw new MightyAppException("Unable to save User Device Mapping", HttpStatus.INTERNAL_SERVER_ERROR, e);
		}
	}
	
	private MightyDeviceInfo getDeviceDetails(String deviceId) {
		return mightyDeviceInfoDAO.getDeviceInfo(deviceId);
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
		
		MightyDeviceInfo mightDeviceInfo = getDeviceDetails(consumerDeviceDto.getMightyDeviceId());
		

		
		registerUserAndDevice(consumerDeviceDto, mightDeviceInfo);
		
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

	public void deregisterDevice(String deviceId) {
		if(null == deviceId) {
			logger.debug("DeRegister Device, Consumer DeviceId is null");
			throw new MightyAppException("Invalid request Object", HttpStatus.BAD_REQUEST);
		}
		
			
		MightyDeviceInfo mightDeviceInfo = getDeviceDetails(deviceId);
		
		if(mightDeviceInfo == null ) {
			throw new MightyAppException("Device Details Not Found in System", HttpStatus.NOT_FOUND);
		}
		
		MightyDeviceUserMapping mightyDeviceUserMapping = mightyDeviceUserMapDAO.getDeviceInfo(mightDeviceInfo.getId());
		
		if(mightyDeviceUserMapping != null) {
			logger.debug(mightyDeviceUserMapping);
			logger.debug(mightyDeviceUserMapping.getMightyUserInfo());
			logger.debug(mightyDeviceUserMapping.getMightyUserInfo().getId());
			mightyDeviceUserMapping.setRegistrationStatus(MightyAppConstants.IND_N);
			updateUserDeviceMap(mightyDeviceUserMapping);
		}
		
		mightDeviceInfo.setIsRegistered(MightyAppConstants.IND_N);
		
		updateForDeRegisterDevice(mightDeviceInfo);
		
	}
	
	private void updateUserDeviceMap(MightyDeviceUserMapping mightyDevUsrMap) {
		try {
			mightyDeviceUserMapDAO.save(mightyDevUsrMap);
		} catch(Exception e) {
			throw new MightyAppException("Unable to update User Device Mapping", HttpStatus.INTERNAL_SERVER_ERROR, e);
		}
	}
	
	public void updateForDeRegisterDevice(MightyDeviceInfo mightDeviceInfo) {
		try {
			mightyDeviceInfoDAO.save(mightDeviceInfo);
		} catch(Exception e) {
			throw new MightyAppException("Unable to update ", HttpStatus.INTERNAL_SERVER_ERROR, e);
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
		
		if(null == isActive || isActive.equalsIgnoreCase(MightyAppConstants.IND_N)) {
			throw new MightyAppException(" Device is not active or status is empty", HttpStatus.GONE);
		}
		
		String isRegistered = mightyDeviceInfo.getIsRegistered();
		
		if(null != isRegistered && isRegistered.equalsIgnoreCase(MightyAppConstants.IND_Y)) {
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