package br.com.cervejaria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cervejaria.entity.CervejaEntity;
import br.com.cervejaria.entity.EstiloCervejaEntity;
import br.com.cervejaria.entity.Origem;
import br.com.cervejaria.entity.Sabor;
import br.com.cervejaria.exception.NameAlreadyCervejaCadastradaException;
import br.com.cervejaria.repository.CervejaDao;
import br.com.cervejaria.repository.EstiloCervejaDao;
import br.com.cervejaria.service.CervejaService;

@Controller
@RequestMapping("/cerveja")
public class CervejaController {

	@Autowired
	private CervejaService service;

	@Autowired
	private EstiloCervejaDao estiloDao;



	@GetMapping("/produto")
	public ModelAndView listar(@ModelAttribute("cerveja") CervejaEntity cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/cadastro-produto");
		return mv;

	}

	@PostMapping("/salvar")
	public ModelAndView cadastrar(@ModelAttribute("cerveja") @Valid CervejaEntity cerveja, BindingResult result,
			RedirectAttributes attr) {

		if (result.hasErrors()) {
			return listar(cerveja);
		}

		ModelAndView mv = new ModelAndView("redirect:/cerveja/produto");
		try {
		service.salvar(cerveja);
		}catch (NameAlreadyCervejaCadastradaException e) {
			result.rejectValue("nome", e.getMessage(),e.getMessage());
			return listar(cerveja);
		}
		attr.addFlashAttribute("success", "Produto cadastrado com sucesso!");

		return mv;
	}

	@ModelAttribute("sabor")
	public Sabor[] getSabores() {
		return Sabor.values();
	}

	@ModelAttribute("estilos")
	public List<EstiloCervejaEntity> getEstilos() {
		return estiloDao.findAll();
	}

	@ModelAttribute("origem")
	public Origem[] getOrigem() {
		return Origem.values();
	}

}
