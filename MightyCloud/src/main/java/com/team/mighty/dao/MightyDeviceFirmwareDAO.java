package com.team.mighty.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.mighty.domain.MightyDeviceFirmware;

public interface MightyDeviceFirmwareDAO extends JpaRepository<MightyDeviceFirmware, Serializable> {

}
