package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import lombok.Data;

@Data
@Entity
@Table(name="BANK_ACCOUNT")
@FilterDef(name="FILTER_REMOVE_ACCOUNTS",
           parameters= {@ParamDef(name = "type1", type = "string"), 
        		        @ParamDef(name = "type2", type = "string"),
        		        @ParamDef(name = "type3", type = "string")
                        }
          )
@Filter(name = "FILTER_REMOVE_ACCOUNTS",condition="STATUS NOT IN(:type1,:type2,:type3)")
public class BankAccount implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int acno;
	private String hodlerName;
	private  float balance;
	private  String status;

}
