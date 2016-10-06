package com.team.mighty.dto;

import java.io.Serializable;
import java.util.List;

public class UserLoginDTO  extends BaseResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Response Details
	private String userStatus;
	
	private long userId;
	
	private String phoneDeviceId;
	
	private List<String> lstMightyDeviceId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPhoneDeviceId() {
		return phoneDeviceId;
	}

	public void setPhoneDeviceId(String phoneDeviceId) {
		this.phoneDeviceId = phoneDeviceId;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public List<String> getLstMightyDeviceId() {
		return lstMightyDeviceId;
	}

	public void setLstMightyDeviceId(List<String> lstMightyDeviceId) {
		this.lstMightyDeviceId = lstMightyDeviceId;
	}

}
