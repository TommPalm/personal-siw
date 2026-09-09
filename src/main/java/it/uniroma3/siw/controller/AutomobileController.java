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
import jakarta.validation.Valid;

@Controller
public class AutomobileController {

    private final AutomobileService automobileService;
    private final UtenteService utenteService;

    public AutomobileController(AutomobileService automobileService,UtenteService utenteService) {
        this.automobileService = automobileService;
        this.utenteService = utenteService;
    }

    @GetMapping("/amm/auto")
    public String auto(Model model) {

        model.addAttribute("automobile", new Automobile());
        model.addAttribute("auto", automobileService.findAll());
        model.addAttribute("users", utenteService.findAll());

        return "amm/auto";
    }

    @PostMapping("/auto")
    public String autoAdd(
            Model model,
            @Valid @ModelAttribute("automobile") Automobile automobile,
            BindingResult automobileBindingResult,
            @RequestParam("userId") Long userId) {

        if (automobileBindingResult.hasErrors()) {
            model.addAttribute("auto", automobileService.findAll());
            model.addAttribute("users", utenteService.findAll());
            return "amm/auto";
        }
        
        if (automobileService.findByPlate(automobile.getPlate()) != null) {
            model.addAttribute("error", "La targa inserita esiste già.");
            model.addAttribute("users", utenteService.findAll());
            return "amm/auto";
        }


        Utente user = utenteService.findById(userId);

        if (user == null) {
            model.addAttribute("error", "L'utente selezionato non esiste.");
            model.addAttribute("auto", automobileService.findAll());
            model.addAttribute("users", utenteService.findAll());
            return "amm/auto";
        }

        automobile.setOwner(user);
        automobileService.save(automobile);

        return "redirect:/amm/auto";
    }

    @PostMapping("/autoRem")
    public String autoRemove(
            Model model,
            @RequestParam("autoId") Long autoId) {

        Automobile automobile = automobileService.findById(autoId);

        if (automobile == null) {
            model.addAttribute("error", "L'auto selezionata non esiste.");
            model.addAttribute("automobile", new Automobile());
            model.addAttribute("auto", automobileService.findAll());
            model.addAttribute("users", utenteService.findAll());

            return "amm/auto";
        }

        automobileService.delete(autoId);

        return "redirect:/amm/auto";
    }
}

