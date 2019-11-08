package br.com.cervejaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@RequestMapping("novo")
	public String cadastrar() {
		return "cerveja/cadastro-cliente";
	}


}
