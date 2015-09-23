package com.analytics.oracle.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Tracking")
public class TrackingOracle implements Serializable
{
	

//	RECORDID   NOT NULL NUMBER(15)     
//	CREATED    NOT NULL TIMESTAMP(6)   
//	LASTRETRY           TIMESTAMP(6)   
//	ENTITYID            VARCHAR2(20)   
//	EVENTTYPE           VARCHAR2(20)   
//	STATUS              VARCHAR2(15)   
//	RETRYCOUNT          NUMBER(5)      
//	DATA                VARCHAR2(4000) 

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "RECORDID")
	private Long recordId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED")
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LASTRETRY")
	private Date lastRetry;
		
	@Column(name = "ENTITYID")
	private String entityId;
		
	@Column(name = "EVENTTYPE")
	private String eventType;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "RETRYCOUNT")
	private int retryCount;
	
	@Column(name = "DATA")
	private String data;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastRetry() {
		return lastRetry;
	}

	public void setLastRetry(Date lastRetry) {
		this.lastRetry = lastRetry;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Tracking [recordId=" + recordId + "]";
	}

	

	

		
}
