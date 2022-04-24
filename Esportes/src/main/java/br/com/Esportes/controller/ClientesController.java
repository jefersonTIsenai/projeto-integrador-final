package br.com.Esportes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.Esportes.models.Clientes;
import br.com.Esportes.repository.ClientesRepository;

@Controller
@RequestMapping(value = "/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesRepository repository;
	
	@GetMapping
	public ModelAndView verTodos() {
		ModelAndView modelAndView = new ModelAndView("Clientes/verTodos");
		return modelAndView;
	}
	@PostMapping
	public ModelAndView salvar(Clientes clientes) {
		repository.save(clientes);
		ModelAndView modelAndView = new ModelAndView("Clientes/verTodos");
		return modelAndView;
		
	}
	
	@PostMapping(value = "/deletar/{id}")
	public String deletar(@PathVariable Integer id) {
		repository.deleteById(id);
		return "redirect:/Clientes";
		
	}
	
	@GetMapping(value = "/editar/{id}")
	public ModelAndView editar (@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("Clientes/editar");
		Optional<Clientes> clientes = repository.findById(id);
		modelAndView.addObject(clientes.get());
		return modelAndView;
				
	}
	
	@PostMapping(value = "/editar")
	public String editarSave(Clientes clientes) {
		repository.save(clientes);
		return "redirect:/clientes";
		
	} 
	
	@GetMapping(value = "/listar")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("Clientes/listar");
		List<Clientes> clientes = (List<Clientes>) repository.findAll();
		modelAndView.addObject(clientes);
		return modelAndView;
	}

}
