package com.leadtone.riders.protocol.beans;

/**
 * { "msg_id":"1vafd", "from":"999991", "to":"AAAAAA", "subject":"reg",
 * "content":{ "email":"lvqi", "password":"1234"},
 * "creationDate":"20130227121212", }
 */

public class RidersMessage {

	private String msg_id;

	private String from;

	private String to;

	private String subject;

	private String content;

	public String getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}
