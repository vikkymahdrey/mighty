package com.team.mighty.service;

import java.util.List;

import com.team.mighty.domain.MightyDeviceFirmware;
import com.team.mighty.domain.MightyDeviceOrderInfo;
import com.team.mighty.dto.DeviceInfoDTO;
import com.team.mighty.exception.MightyAppException;

public interface AdminInstrumentService {

	public List<DeviceInfoDTO> getAllMightyDevice() throws MightyAppException;
	
	public MightyDeviceOrderInfo createDeviceOrder(MightyDeviceOrderInfo mightyDeviceOrderInfo) throws MightyAppException;
	
	public MightyDeviceFirmware createDeviceFirmware(MightyDeviceFirmware mightyDeviceFirmware) throws MightyAppException;
}
