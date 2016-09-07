package com.team.mighty.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_MIGHTY_USR_DEV_MAP")
public class MightyDeviceUserMapping extends BaseEntityInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "PHONE_DEVICE_ID")
	private String phoneDeviceId;
	
	@Column(name = "PHONE_DEVICE_TYPE")
	private String phoneDeviceType;
	
	@Column(name = "PHONE_DEVICE_VERSION")
	private String phoneDeviceVersion;
	
	@Column(name = "PHONE_DEVICE_OS_VERSION")
	private String phoneDeviceOSVersion;
	
	@Column(name = "MIGHTY_DEVICE_ID")
	private long mightyDeviceId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPhoneDeviceId() {
		return phoneDeviceId;
	}

	public void setPhoneDeviceId(String phoneDeviceId) {
		this.phoneDeviceId = phoneDeviceId;
	}

	public String getPhoneDeviceType() {
		return phoneDeviceType;
	}

	public void setPhoneDeviceType(String phoneDeviceType) {
		this.phoneDeviceType = phoneDeviceType;
	}

	public String getPhoneDeviceVersion() {
		return phoneDeviceVersion;
	}

	public void setPhoneDeviceVersion(String phoneDeviceVersion) {
		this.phoneDeviceVersion = phoneDeviceVersion;
	}

	public String getPhoneDeviceOSVersion() {
		return phoneDeviceOSVersion;
	}

	public void setPhoneDeviceOSVersion(String phoneDeviceOSVersion) {
		this.phoneDeviceOSVersion = phoneDeviceOSVersion;
	}

	public long getMightyDeviceId() {
		return mightyDeviceId;
	}

	public void setMightyDeviceId(long mightyDeviceId) {
		this.mightyDeviceId = mightyDeviceId;
	}
	
}
