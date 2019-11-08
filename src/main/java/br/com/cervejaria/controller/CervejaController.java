package br.com.cervejaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cerveja")
public class CervejaController {
	
	@GetMapping("/estilo")
	public String cadastroEstilo() {
		return "cerveja/cadastro-estilo";
		
	}
	
	
	@GetMapping("/produto")
	public String cadastroproduto() {
		return "cerveja/cadastro-produto";
		
	}

}
