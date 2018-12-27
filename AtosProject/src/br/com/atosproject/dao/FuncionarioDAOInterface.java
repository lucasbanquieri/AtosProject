package br.com.atosproject.dao;

import java.util.List;

import br.com.atosproject.model.Funcionario;
import br.com.atosproject.model.Project;

public interface FuncionarioDAOInterface {
	public List<Funcionario> listarFuncionarios();
	public List<Project> listarProjetos(long idEmployee);
	public List<String> retornaSkills(long idEmployee);
	public List<String> retornaCertifications(long idEmployee);
}
