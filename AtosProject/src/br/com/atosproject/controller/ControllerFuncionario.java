package br.com.atosproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerFuncionario {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
