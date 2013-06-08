package com.leadtone.riders.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;


@Entity
@Table(name="report")
public class Report {

	private Long rid;
	
	private User uid;
	
	private String clientName;
	
	private Double clientVersion;
	
	private String osVersion;
	
	private String resolution;
	
	private String mobile;
	
	private String deviceToken;
	
	private Integer pushType;
	
	private Date updateTime;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	@NotNull
	@OneToOne
	@JoinColumn(name = "uid")
	public User getUid() {
		return uid;
	}

	public void setUid(User uid) {
		this.uid = uid;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Double getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(Double clientVersion) {
		this.clientVersion = clientVersion;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public Integer getPushType() {
		return pushType;
	}

	public void setPushType(Integer pushType) {
		this.pushType = pushType;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
