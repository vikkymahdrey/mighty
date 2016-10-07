package com.team.mighty.domain;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TBL_MIGHTY_USER_INFO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MightyUserInfo extends BaseEntityInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MightyUserInfo() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "SPOTIFY_ACCESS_TOKEN")
	private String spotifyAccessToken;

	@Column(name = "SPOTIFY_REFRESH_TOKEN")
	private String spotifyRefreshToken;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "USER_STATUS")
	private String userStatus;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "CREATED_DT")
	private Date createdDt;
	
	@Column(name = "UPDATED_DT")
	private Date updatedDt;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<MightyDeviceUserMapping> mightyDeviceUserMapping;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSpotifyAccessToken() {
		return spotifyAccessToken;
	}

	public void setSpotifyAccessToken(String spotifyAccessToken) {
		this.spotifyAccessToken = spotifyAccessToken;
	}

	public String getSpotifyRefreshToken() {
		return spotifyRefreshToken;
	}

	public void setSpotifyRefreshToken(String spotifyRefreshToken) {
		this.spotifyRefreshToken = spotifyRefreshToken;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<MightyDeviceUserMapping> getMightyDeviceUserMapping() {
		return mightyDeviceUserMapping;
	}

	public void setMightyDeviceUserMapping(Set<MightyDeviceUserMapping> mightyDeviceUserMapping) {
		this.mightyDeviceUserMapping = mightyDeviceUserMapping;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public Date getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

}
