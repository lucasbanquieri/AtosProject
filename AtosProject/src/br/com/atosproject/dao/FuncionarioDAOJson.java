package br.com.atosproject.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.atosproject.model.Funcionario;
import br.com.atosproject.model.Project;

/**
 * Classe que contem os metodos de leitura do arquivo JSON que contem informacoes dos funcionarios.
 * 
 * @author Lucas Banquieri
 *
 */

public class FuncionarioDAOJson implements FuncionarioDAOJsonInterface{
	
	/**
	 * Metodo responsavel por ler o arquivo JSON contendo os dados do funcionario e retornar uma lista dos mesmos.
	 * Diretorio do arquivo JSON pode ser alterado na linha 44.
	 * 
	 * @return List retorna uma lista de funcionarios contidos no JSON.
	 */
	
	public List<Funcionario> listarFuncionariosJson() {
		JSONArray jObject;
		JSONParser jParser = new JSONParser();
		Funcionario funcionario;
		Project pro;
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			// FAZ A LEITURA DO ARQUIVO JSON.
			jObject = (JSONArray) jParser.parse(new FileReader("D:\\employees.json"));
			
			// LOOP PRINCIPAL QUE MONTA OS OBJETOS FUNCIONARIO E ADICIONA NO List<Funcionario> funcionarios.
			for (int i = 0; i < jObject.size(); i++) {
				JSONObject jFuncionario = (JSONObject) jObject.get(i);
				
				funcionario = new Funcionario();
				
				funcionario.setIdFuncionario(i);
				funcionario.setName(jFuncionario.get("name").toString());
				funcionario.setRole(jFuncionario.get("role").toString());
				funcionario.setSalary(jFuncionario.get("salary").toString());
				funcionario.setManager(jFuncionario.get("manager").toString());
				funcionario.setGcm(jFuncionario.get("gcm").toString());
				
				// DENTRO DESTE IF SÃO INSTANCIADOS OS PROJETOS QUE SERÃO POPULADOS E ADICIONADOS AO FUNCIONARIO.
				if (jFuncionario.get("projects") != null) {
					JSONArray projectArray = (JSONArray) jFuncionario.get("projects");
					List<Project> projectList = new ArrayList<Project>();
					
					for (int j = 0; j < projectArray.size(); j++) {
						JSONObject projects = (JSONObject) projectArray.get(j);
						pro = new Project();
						
						pro.setName(projects.get("name").toString());
						pro.setCustomer(projects.get("customer").toString());
						pro.setValueOfProject(projects.get("valueOfProject").toString());
						pro.setDtBegin(projects.get("dtBegin").toString());
						pro.setDtEnd(projects.get("dtEnd").toString());
						
						projectList.add(pro);
					}
					funcionario.setProjectList(projectList);
				}
				
				// DENTRO DESTE IF SÃO ADICIONADOS AS SKILLS DO FUNCIONARIO.
				if (jFuncionario.get("skills") != null) {
					JSONArray skillArray = (JSONArray) jFuncionario.get("skills");
					Iterator<String> iterator = skillArray.iterator();
					List<String> skills = new ArrayList<String>();
					
					while (iterator.hasNext()) {
						skills.add(iterator.next());
						funcionario.setSkills(skills);
					}
				}
				
				// DENTRO DESTE IF SÃO ADICIONADOS AS CERTIFICATIONS DO FUNCIONARIO.
				if (jFuncionario.get("certification") != null) {
					JSONArray certificationArray = (JSONArray) jFuncionario.get("certification");
					Iterator<String> iterator = certificationArray.iterator();
					List<String> certifications = new ArrayList<String>();
					
					while (iterator.hasNext()) {
						certifications.add(iterator.next());
						funcionario.setCertification(certifications);
					}
				}
				// FUNCIONARIO POPULADO ADICIONADO NA LISTA.
				funcionarios.add(funcionario);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			funcionarios = null;
		} catch (IOException e) {
			e.printStackTrace();
			funcionarios = null;
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Ocorreu um erro no parse do arquivo.");
		}
		return funcionarios;
	}
}
