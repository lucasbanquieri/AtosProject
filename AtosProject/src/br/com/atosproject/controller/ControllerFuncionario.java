package br.com.atosproject.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.atosproject.model.Funcionario;
import br.com.atosproject.model.Project;

@Controller
public class ControllerFuncionario {
	
	@RequestMapping("/index")
	public String index(Model model, String[] filters) {
		
		JSONArray jObject;
		JSONParser jParser = new JSONParser();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			
			jObject = (JSONArray) jParser.parse(new FileReader("D:\\employees.json"));
			
			for (int i = 0; i < jObject.size(); i++) {
				JSONObject jFuncionario = (JSONObject) jObject.get(i);
				
				Funcionario funcionario = new Funcionario();
				
				funcionario.setIdFuncionario(i);
				funcionario.setName(jFuncionario.get("name").toString());
				funcionario.setRole(jFuncionario.get("role").toString());
				funcionario.setSalary(jFuncionario.get("salary").toString());
				funcionario.setManager(jFuncionario.get("manager").toString());
				funcionario.setGcm(jFuncionario.get("gcm").toString());
				
				if (jFuncionario.get("projects") != null) {
					JSONArray projectArray = (JSONArray) jFuncionario.get("projects");
					List<Project> projectList = new ArrayList<Project>();
					
					for (int j = 0; j < projectArray.size(); j++) {
						JSONObject projects = (JSONObject) projectArray.get(j);
						Project pro = new Project();
						
						pro.setName(projects.get("name").toString());
						pro.setCustomer(projects.get("customer").toString());
						pro.setValueOfProject(projects.get("valueOfProject").toString());
						pro.setDtBegin(projects.get("dtBegin").toString());
						pro.setDtEnd(projects.get("dtEnd").toString());
						
						projectList.add(pro);
					}
					funcionario.setProjectList(projectList);
				}
				
				if (jFuncionario.get("skills") != null) {
					JSONArray skillArray = (JSONArray) jFuncionario.get("skills");
					Iterator<String> iterator = skillArray.iterator();
					String[] skills = new String[skillArray.size()];
					
					while (iterator.hasNext()) {						
						for (int k = 0; k < skills.length; k++) {
							skills[k] = iterator.next();
						}
						funcionario.setSkills(skills);
					}
					//TEMPORARIO
					if (filters != null) {
						boolean contains = false;
						for (int l = 0; l < filters.length; l++) {
							if (!contains) {
								for (int m = 0; m < skills.length; m++) {
									if (filters[l].equals(skills[m])) {
										contains = true;
										break;
									}
								}
							} else {
								break;
							}
						}
					}
				}
				
				if (jFuncionario.get("certification") != null) {
					JSONArray certificationArray = (JSONArray) jFuncionario.get("certification");
					Iterator<String> iterator = certificationArray.iterator();
					
					while (iterator.hasNext()) {
						String[] certifications = new String[certificationArray.size()];
						
						for (int l = 0; l < certifications.length; l++) {
							certifications[l] = iterator.next();
						}
						funcionario.setCertification(certifications);
					}
				}
				funcionarios.add(funcionario);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		model.addAttribute("funcionarios", funcionarios);
		return "index";
	}
}
