package br.com.atosproject.model;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
	
	private long idFuncionario;
	private String name;
	private String role;
	private String salary;
	private String manager;
	private String gcm;
	private String[] skills;
	private String[] certification;
	private List<Project> projectList = new ArrayList<Project>();
	
	
	public long getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
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
	public List<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
}
