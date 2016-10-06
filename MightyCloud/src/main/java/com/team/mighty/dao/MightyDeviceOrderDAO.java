package com.team.mighty.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.mighty.domain.MightyDeviceOrderInfo;

public interface MightyDeviceOrderDAO extends JpaRepository<MightyDeviceOrderInfo,Serializable>{

}
