package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProgrammersProjectsInfo implements Serializable {
   private PrgmrProjId id;
   private String prgmrName;
   private String projName;
   private float salary;
}
