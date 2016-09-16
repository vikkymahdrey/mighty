package com.team.mighty.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.team.mighty.dao.MightyDeviceInfoDAO;
import com.team.mighty.domain.MightyDeviceInfo;
import com.team.mighty.dto.DeviceInfoDTO;
import com.team.mighty.exception.MightyAppException;
import com.team.mighty.logger.MightyLogger;
import com.team.mighty.service.AdminInstrumentService;

@Service("adminInstrumentServiceImpl")
public class AdminInstrumentServiceImpl implements AdminInstrumentService {

	private static final MightyLogger logger = MightyLogger.getLogger(AdminInstrumentServiceImpl.class);
	
	@Autowired
	private MightyDeviceInfoDAO mightyDeviceInfoDAO;
	
	public List<DeviceInfoDTO> getAllMightyDevice() throws MightyAppException {
		logger.info("AdminInstrumentServiceImpl,getAllMightyDevice");
		List<MightyDeviceInfo> lstMightDeviceInfo = new ArrayList<MightyDeviceInfo>();
		List<DeviceInfoDTO> lstDeviceDTO = new ArrayList<DeviceInfoDTO>();
		try {
			lstMightDeviceInfo = mightyDeviceInfoDAO.findAll();
			
			if(lstMightDeviceInfo != null && !lstMightDeviceInfo.isEmpty()) {
				for(MightyDeviceInfo mightyDevice : lstMightDeviceInfo){
					DeviceInfoDTO deviceInfoDTO = new DeviceInfoDTO();
					deviceInfoDTO.setDeviceId(mightyDevice.getDeviceId());
					deviceInfoDTO.setIsActive(mightyDevice.getIsActive());
					deviceInfoDTO.setIsRegistered(mightyDevice.getIsRegistered());
					lstDeviceDTO.add(deviceInfoDTO);
				}
			}
			
		} catch(MightyAppException e) {
			throw new MightyAppException("Unable to retrive device", HttpStatus.INTERNAL_SERVER_ERROR, e); 
		}
		return lstDeviceDTO;
	}

}
