package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="PROGRAMMERS_PROJECTS")
public class ProgrammersProjectsInfo implements Serializable {
     @EmbeddedId
	private PrgmrProjId id;
     @Column(name="PRGMRNAME")
     @Type(type="string")     
   private String prgmrName;
     @Column(name="PROJNAME")
     @Type(type="string")   
   private String projName;
     @Column(name="SALARY")
     @Type(type="float")   
   private float salary;
}
