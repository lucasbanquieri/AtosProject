package br.com.atosproject.model;

import java.math.BigDecimal;

public class Funcionario {
	private String name;
	private String role;
	private BigDecimal salary;
	private String manager;
	private String gcm;
	private String[] skills;
	private String[] certification;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getGcm() {
		return gcm;
	}
	public void setGcm(String gcm) {
		this.gcm = gcm;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	public String[] getCertification() {
		return certification;
	}
	public void setCertification(String[] certification) {
		this.certification = certification;
	}
}
