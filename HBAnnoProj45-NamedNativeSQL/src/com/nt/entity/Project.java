package com.nt.entity;
// Generated May 25, 2019 5:46:16 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT")
@NamedNativeQuery(name="GET_PROJS_BY_IDS",
                  query="SELECT PROJID,PROJNAME,TEAMSIZE,STARTDATE,RELEASEDATE FROM PROJECT WHERE PROJID>=:min AND PROJID<=:max",
                  resultClass=Project.class)
@NamedNativeQuery(name="UPDATE_PROJS",
                  query="UPDATE PROJECT SET TEAMSIZE=TEAMSIZE+1 "
                  )
public class Project implements java.io.Serializable {
    @Id	
    @GeneratedValue(strategy=GenerationType.AUTO)
	private short projid;
	private String projname;
	private Short teamsize;
	private Date startdate;
	private Date releasedate;

	public Project() {
		System.out.println("Project:0-param constructor");
	}

	public Project(short projid) {
		this.projid = projid;
	}

	public Project(short projid, String projname, Short teamsize, Date startdate, Date releasedate) {
		this.projid = projid;
		this.projname = projname;
		this.teamsize = teamsize;
		this.startdate = startdate;
		this.releasedate = releasedate;
	}

	public short getProjid() {
		return this.projid;
	}

	public void setProjid(short projid) {
		this.projid = projid;
	}

	public String getProjname() {
		return this.projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

	public Short getTeamsize() {
		return this.teamsize;
	}

	public void setTeamsize(Short teamsize) {
		this.teamsize = teamsize;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getReleasedate() {
		return this.releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

	@Override
	public String toString() {
		return "Project [projid=" + projid + ", projname=" + projname + ", teamsize=" + teamsize + ", startdate="
				+ startdate + ", releasedate=" + releasedate + "]";
	}

}
