package com.telusko.advice;

import java.time.LocalDateTime;

public class ErrorDetails 
{

	private String msg;
	
	private LocalDateTime time;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ErrorDetails [msg=" + msg + ", time=" + time + "]";
	}

	public ErrorDetails(String msg, LocalDateTime time) {
		super();
		this.msg = msg;
		this.time = time;
	}

	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
