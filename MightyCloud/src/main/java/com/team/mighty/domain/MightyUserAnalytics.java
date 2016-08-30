package com.team.mighty.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_MIGHTY_USER_ANALYTICS")
public class MightyUserAnalytics extends BaseEntityInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name = "APPLICATION_TYPE")
	private String applicationType;
	
	@Column(name = "ANALYTICS_TYPE")
	private String analyticsType;
	
	@Column(name = "PLAY_LIST_ID")
	private String playListId;
	
	@Column(name = "SONG_ID")
	private String songId;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "FIELD_1")
	private String field_1;
	
	@Column(name = "FIELD_2")
	private String field_2;
	
	@Column(name = "FIELD_3")
	private String field_3;
	
	@Column(name = "FIELD_4")
	private String field_4;
	
	@Column(name = "FIELD_5")
	private String field_5;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getAnalyticsType() {
		return analyticsType;
	}

	public void setAnalyticsType(String analyticsType) {
		this.analyticsType = analyticsType;
	}

	public String getPlayListId() {
		return playListId;
	}

	public void setPlayListId(String playListId) {
		this.playListId = playListId;
	}

	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getField_1() {
		return field_1;
	}

	public void setField_1(String field_1) {
		this.field_1 = field_1;
	}

	public String getField_2() {
		return field_2;
	}

	public void setField_2(String field_2) {
		this.field_2 = field_2;
	}

	public String getField_3() {
		return field_3;
	}

	public void setField_3(String field_3) {
		this.field_3 = field_3;
	}

	public String getField_4() {
		return field_4;
	}

	public void setField_4(String field_4) {
		this.field_4 = field_4;
	}

	public String getField_5() {
		return field_5;
	}

	public void setField_5(String field_5) {
		this.field_5 = field_5;
	}
}
