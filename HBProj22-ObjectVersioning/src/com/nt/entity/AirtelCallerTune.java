package com.nt.entity;

import java.io.Serializable;

public class AirtelCallerTune implements Serializable {
	private int custId;
	private String custName;
	private long mobileNo;
	private String callerTune;
	private int updationsCount;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCallerTune() {
		return callerTune;
	}
	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}
	public int getUpdationsCount() {
		return updationsCount;
	}
	public void setUpdationsCount(int updationsCount) {
		this.updationsCount = updationsCount;
	}
	
	@Override
	public String toString() {
		return "AirtelCallerTune [custId=" + custId + ", custName=" + custName + ", mobileNo=" + mobileNo
				+ ", callerTune=" + callerTune + ", updationsCount=" + updationsCount + "]";
	}
	
	

}
