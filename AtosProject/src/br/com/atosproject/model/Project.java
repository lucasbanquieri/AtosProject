package br.com.atosproject.model;

/**
 * Classe que representa os projetos de um funcionario.
 * 
 * @author Lucas Banquieri
 *
 */

public class Project {
	
	private long projectId;
	private String name;
	private String customer;
	private String valueOfProject;
	private String dtBegin;
	private String dtEnd;
	private Funcionario funcionario;
	
	
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
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
	public String getValueOfProject() {
		return valueOfProject;
	}
	public void setValueOfProject(String valueOfProject) {
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
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
