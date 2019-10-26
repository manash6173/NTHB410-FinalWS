package com.nt.dto;

import java.io.Serializable;
import java.util.Date;

public class ProjectDTO implements Serializable {
	private int projId;
	private String projName;
	private int teamSize;
	private String domain;
	private Date  sdp;
	private  Date edcp;
	
	public ProjectDTO() {
		System.out.println("ProjectDTO:0-param constructor");
	}
	
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Date getSdp() {
		return sdp;
	}
	public void setSdp(Date sdp) {
		this.sdp = sdp;
	}
	public Date getEdcp() {
		return edcp;
	}
	public void setEdcp(Date edcp) {
		this.edcp = edcp;
	}
    
}
