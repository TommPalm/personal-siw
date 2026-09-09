package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.*;
import it.uniroma3.siw.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class RicambioController {

	private final RicambioService ricambioService;

	public RicambioController(RicambioService ricambioService) {
		this.ricambioService = ricambioService;
	}
	
	
	@GetMapping("/amm/ricambio")
	public String ricambio(Model model) {
		model.addAttribute("ricambio", new Ricambio());
		model.addAttribute("ric", ricambioService.findAll());
		return "amm/ricambio";
	}
	
	@PostMapping("/ricambio")
	public String ricambio(@Valid @ModelAttribute("ricambio") Ricambio ricambio,
			BindingResult bindingResult,
	        Model model,
            HttpServletRequest request) throws ServletException {
		
		if (bindingResult.hasErrors()) {
	        model.addAttribute("ric", ricambioService.findAll());
	        return "amm/ricambio";
	    }
		
		if(ricambioService.existsByNome(ricambio.getNome()) && ricambioService.existsByProducer(ricambio.getProducer())) {
			Ricambio ric = ricambioService.findByNomeAndProducer(ricambio.getNome(), ricambio.getProducer());
			ricambio.setId(ric.getId());
		}
		
		ricambioService.save(ricambio);
		 return "redirect:amm/ricambio";
	}
	
	@PostMapping("/ricambioRem")
	public String ricambioRemove(Model model,@RequestParam("ricambioId") Long ricambioId) {

	    Ricambio ricambio = ricambioService.findById(ricambioId);

	    if (ricambio == null) {
	    	model.addAttribute("error", "Il componente selezionato non esiste.");
	        return "amm/ricambio";
	    }
	    
	   ricambioService.delete(ricambioId);

	   return "redirect:amm/ricambio";
	}
	
}
