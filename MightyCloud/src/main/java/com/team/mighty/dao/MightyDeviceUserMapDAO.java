package com.team.mighty.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team.mighty.domain.MightyDeviceUserMapping;

public interface MightyDeviceUserMapDAO extends JpaRepository<MightyDeviceUserMapping, Serializable>{

	@Query("SELECT m FROM MightyDeviceUserMapping m WHERE m.mightyDeviceId = :deviceId")
	MightyDeviceUserMapping getDeviceInfo(@Param("deviceId") long deviceId);
}
