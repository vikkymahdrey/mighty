package com.team.mighty.service;

import java.util.List;

import com.team.mighty.dto.DeviceInfoDTO;
import com.team.mighty.exception.MightyAppException;

public interface AdminInstrumentService {

	public List<DeviceInfoDTO> getAllMightyDevice() throws MightyAppException;
}
