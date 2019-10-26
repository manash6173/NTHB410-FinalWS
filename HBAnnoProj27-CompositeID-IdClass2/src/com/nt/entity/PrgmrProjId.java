//Composite Id Class
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Embeddable
public class PrgmrProjId implements Serializable {
	@Column(name="PRGMRID")
	@Type(type="int")
	private int prgmrId;
	@Column(name="PROJID")
	@Type(type="int")
	private int projId;

}
