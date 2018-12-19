package br.com.atosproject.model;

import java.math.BigDecimal;

public class Project {
	private String name;
	private String customer;
	private BigDecimal valueOfProject;
	private String dtBegin;
	private String dtEnd;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public BigDecimal getValueOfProject() {
		return valueOfProject;
	}
	public void setValueOfProject(BigDecimal valueOfProject) {
		this.valueOfProject = valueOfProject;
	}
	public String getDtBegin() {
		return dtBegin;
	}
	public void setDtBegin(String dtBegin) {
		this.dtBegin = dtBegin;
	}
	public String getDtEnd() {
		return dtEnd;
	}
	public void setDtEnd(String dtEnd) {
		this.dtEnd = dtEnd;
	}
}
