package br.com.atosproject.daotest;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.atosproject.dao.FuncionarioDAO;
import br.com.atosproject.dao.FuncionarioDAOInterface;
import br.com.atosproject.model.Funcionario;
import br.com.atosproject.model.Project;

public class FuncionarioDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("unused")
	@Test
	public void testListarFuncionarios() {
		FuncionarioDAOInterface dao = new FuncionarioDAO();
		
		try {
			List<Funcionario> listaFuncionarios = dao.listarFuncionarios();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Erro ao listar funcionarios.");
		}
	}
	
	@Test
	public void testListarProjetos() {
		FuncionarioDAOInterface dao = new FuncionarioDAO();
		
		try {
			List<Project> listaProjetos = dao.listarProjetos(1);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Erro ao listar projetos.");
		}
	}
	
	@Test
	public void testListarSkills() {
		FuncionarioDAOInterface dao = new FuncionarioDAO();
		
		try {
			List<String> listaProjetos = dao.retornaSkills(1);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Erro ao listar skills.");
		}
	}
	
	@Test
	public void testListarCertifications() {
		FuncionarioDAOInterface dao = new FuncionarioDAO();
		
		try {
			List<String> listaProjetos = dao.retornaCertifications(1);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Erro ao listar certifications.");
		}
	}
}
