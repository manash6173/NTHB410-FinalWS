package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Viechle implements Serializable {
	private int vid;
	private String type;
	private String model;
	private String company;
	private float price;

}
