package br.com.atosproject.daotest;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.atosproject.dao.FuncionarioDAOJson;
import br.com.atosproject.dao.FuncionarioDAOJsonInterface;
import br.com.atosproject.model.Funcionario;

public class FuncionarioDAOJsonTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testListarFuncionariosJson() {
		FuncionarioDAOJsonInterface dao = new FuncionarioDAOJson();
		
		try {
			List<Funcionario> listaFuncionarios = dao.listarFuncionariosJson();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Erro ao listar funcionarios JSON.");
		}
	}

}
