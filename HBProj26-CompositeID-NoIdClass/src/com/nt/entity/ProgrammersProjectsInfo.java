package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProgrammersProjectsInfo implements Serializable {
   private int prgmrId;
   private int projId;
   private String prgmrName;
   private String projName;
   private float salary;
}
