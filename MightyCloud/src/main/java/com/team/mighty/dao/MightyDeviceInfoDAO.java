package com.team.mighty.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team.mighty.domain.MightyDeviceInfo;

public interface MightyDeviceInfoDAO extends JpaRepository<MightyDeviceInfo, Long> {

	@Query("SELECT m FROM MightyDeviceInfo m WHERE m.deviceId = :deviceId")
	MightyDeviceInfo getDeviceInfo(@Param("deviceId") String deviceId);
}
