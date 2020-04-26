package com.ejb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity 
public class Account implements Serializable{
    

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private double solde;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	private boolean active;
	/**
	 * class constructor
	 */
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(String code, double solde, Date createDate, boolean active) {
		super();
		this.code = code;
		this.solde = solde;
		this.createDate = createDate;
		this.active = active;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", code=" + code + ", solde=" + solde + ", createDate=" + createDate + ", active="
				+ active + "]";
	}
	
	
	
	
	
}
