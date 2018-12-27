package br.com.atosproject.controllertest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import br.com.atosproject.controller.ControllerFuncionario;
import br.com.atosproject.model.Funcionario;
import br.com.atosproject.model.Project;

/**
 * Classe responsavel pelos testes JUnit.
 * 
 * @author Lucas Banquieri
 *
 */

@SuppressWarnings("unused")
@RunWith(MockitoJUnitRunner.class)
public class ControllerFuncionarioTest {
	
	private ControllerFuncionario controllerFuncionario;
	
    @Mock
    private Model model;
	
	@Before
	public void setUp() throws Exception {
		controllerFuncionario = new ControllerFuncionario();
	}
	
	/**
	 * Testa o metodo da controller da pagina principal(Versao JSON).
	 */
	
	@Test
	public void testIndexJsonRequest() {
		String retorno = controllerFuncionario.index(model);
        assertEquals("index", retorno);
	}
	
	/**
	 * Testa o metodo da controller da pagina principal(Versao DB).
	 */
	
	@Test
	public void testIndexDbRequest() {
		String retorno = controllerFuncionario.indexDb(model);
        assertEquals("index", retorno);
	}

}
