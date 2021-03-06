package com.example.springboot02.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springboot02.model.Pessoa;
import com.example.springboot02.repository.IPessoaRepository;


@Controller
public class PessoaController {

	@Autowired
	private IPessoaRepository pessoaRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/cadastropessoa")
	public ModelAndView inicio() {
		return pessoas();
		/*
		 * ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
		 * andView.addObject("pessoaobj", new Pessoa()); return andView;
		 */
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "**/salvarpessoa")
	public ModelAndView salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		return pessoas();
		/*
		 * ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
		 * Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
		 * andView.addObject("pessoas",pessoasIt); andView.addObject("pessoaobj", new
		 * Pessoa()); return andView;
		 */
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listapessoas")
	public ModelAndView pessoas() {
		ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
		andView.addObject("pessoas",pessoasIt);
		andView.addObject("pessoaobj", new Pessoa());
		return andView;
	}
	
	@GetMapping("/editarpessoa/{idpessoa}")
	public ModelAndView editar(@PathVariable("idpessoa") Long idpessoa) {		
		Optional<Pessoa> pessoa = pessoaRepository.findById(idpessoa);
		ModelAndView andView = new ModelAndView("cadastro/cadastro");
		andView.addObject("pessoaobj", new Pessoa());
		return andView;
	}
	
	@GetMapping("/excluirpessoa/{idpessoa}")
	public ModelAndView excluir(@PathVariable("idpessoa") Long idpessoa) {
		pessoaRepository.deleteById(idpessoa);
		return pessoas();
	}
}
