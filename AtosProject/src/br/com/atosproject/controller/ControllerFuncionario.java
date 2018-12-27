package br.com.atosproject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.atosproject.dao.FuncionarioDAO;
import br.com.atosproject.dao.FuncionarioDAOInterface;
import br.com.atosproject.dao.FuncionarioDAOJson;
import br.com.atosproject.dao.FuncionarioDAOJsonInterface;
import br.com.atosproject.model.Funcionario;

/**
 * Classe controladora Spring que recebe requisicoes web retornando JSPs. 
 * 
 * @author Lucas Banquieri
 * 
 */

@Controller
public class ControllerFuncionario {
	
	/**
	 * Metodo responsavel pela pagina principal(index). Faz a leitura de um arquivo JSON contendo dados de funcionarios.
	 * Retorna uma pagina JSP, passando como Model uma lista de funcionarios.
	 * 
	 * @param model Objeto do tipo Model que recebera a lista de funcionarios, passando a mesma para a JSP.
	 * @return index.jsp
	 */
	
	@RequestMapping("/index")
	public String index(Model model) {
		FuncionarioDAOJsonInterface dao = new FuncionarioDAOJson();
		List<Funcionario> funcionarios = dao.listarFuncionariosJson();
		
		if (funcionarios == null) {
			return "errorPages/fileNotFoundError";
		} else {
			model.addAttribute("funcionarios", funcionarios);
			return "index";
		}
	}
	
	/**
	 * Metodo responsavel pela pagina principal(index). Busca os dados em um Banco de Dados contendo os dados dos funcionarios.
	 * Monta uma lista de Funcionarios com seus respectivos dados e projetos(Project).
	 * Retorna uma pagina JSP, passando como Model uma lista de funcionarios.
	 * 
	 * @param model Objeto do tipo Model.
	 * @return index.jsp
	 */
	
	@RequestMapping("/indexdb")
	public String indexDb(Model model) {
		FuncionarioDAOInterface dao = new FuncionarioDAO();
		
		try {
			// CHAMA O METODO NA DAO RESPONSAVEL POR LISTAR OS FUNCIONARIOS E RETORNAR A LISTA NO MODEL.
			model.addAttribute("funcionarios", dao.listarFuncionarios());
			return "index";
		} catch(Exception e) {
			e.printStackTrace();
			return "errorPages/dbError";
		}
	}
}
