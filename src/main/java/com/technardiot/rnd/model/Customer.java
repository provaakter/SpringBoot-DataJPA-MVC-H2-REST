package com.technardiot.rnd.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private int tid;
	private String tname;
	private String ttype;

	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTtype() {
		return ttype;
	}
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	@Override
	public String toString() {
		return "Customer [tid=" + tid + ", tname=" + tname + ", ttype=" + ttype + "]";
	}
}