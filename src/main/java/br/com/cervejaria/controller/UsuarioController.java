package br.com.cervejaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@GetMapping("/novo")
	public String novo() {
		return "cerveja/cadastro-usuario";
	}
	
	@GetMapping("/cidade")
	public String cidade() {
		return "cerveja/cadastro-cidade";
	}
	
	
	
	

}
