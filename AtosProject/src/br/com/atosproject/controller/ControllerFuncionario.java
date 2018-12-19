package br.com.atosproject.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.atosproject.model.Funcionario;

@Controller
public class ControllerFuncionario {
	
	@RequestMapping("/")
	public String index() {
		
		JSONArray jObject;
		JSONParser jParser = new JSONParser();
		
		try {
			
			jObject = (JSONArray) jParser.parse(new FileReader("D:\\employees.json"));
			
			for (int i = 0; i < jObject.size(); i++) {
				JSONObject jFuncionario = (JSONObject) jObject.get(i);
				
				Funcionario funcionario = new Funcionario();
				
				funcionario.setName(jFuncionario.get("name").toString());
				funcionario.setRole(jFuncionario.get("role").toString());
				funcionario.setSalary((BigDecimal)jFuncionario.get("salary"));
				funcionario.setManager(jFuncionario.get("manager").toString());
				funcionario.setGcm(jFuncionario.get("gcm").toString());
				
				if (jFuncionario.get("projects") != null) {
					JSONArray projectArray = (JSONArray) jFuncionario.get("projects");
					
					for (int j = 0; j < projectArray.size(); j++) {
						JSONObject projects = (JSONObject) projectArray.get(j);
						System.out.println(projects.get("name"));
					}
				}
				
				if (jFuncionario.get("skills") != null) {
					JSONArray skillArray = (JSONArray) jFuncionario.get("skills");
					Iterator<String> iterator = skillArray.iterator();
					
					while (iterator.hasNext()) {
						String[] skills = new String[skillArray.size()];
						
						for (int k = 0; k < skills.length; k++) {
							skills[k] = iterator.next();
						}
						funcionario.setSkills(skills);
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
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "index";
	}
}
