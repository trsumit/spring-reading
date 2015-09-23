package com.analytics.mongodb.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tracking")
@TypeAlias("Tracking")
public class Tracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long recordId;

	private Date created;

	private Date lastRetry;

	private String entityId;

	private String eventType;

	private String status;

	private int retryCount;

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
		return "Tracking [recordId=" + recordId + ", created=" + created + ", lastRetry=" + lastRetry + ", entityId="
				+ entityId + ", eventType=" + eventType + ", status=" + status + ", retryCount=" + retryCount
				+ ", data=" + data + "]";
	}

	
	
	
	
}
