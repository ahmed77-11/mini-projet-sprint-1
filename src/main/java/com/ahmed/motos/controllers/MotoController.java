package com.ahmed.motos.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahmed.motos.entities.Model;
import com.ahmed.motos.entities.Moto;
import com.ahmed.motos.service.MotoService;

import jakarta.validation.Valid;

@Controller
public class MotoController {

	@Autowired
	MotoService motoService;

	@RequestMapping("/ListeMotos")
	public String listeMotos(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "5") int size) {
		Page<Moto> motos =motoService.getAllMotosParPage(page, size);
		modelMap.addAttribute("motos", motos);
		modelMap.addAttribute("pages", new int[motos.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		
		return "listeMotos";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Model> models=motoService.getAllModels();
		modelMap.addAttribute("moto", new Moto());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("models",models);
		return "formMoto";
	}

	@RequestMapping("/saveMoto")
	public String saveMoto(@ModelAttribute("moto") @Valid Moto moto,BindingResult bindingResult){
		if (bindingResult.hasErrors()) return "formMoto";
		 motoService.saveMoto(moto);
		 return ("redirect:/ListeMotos");
	}

	@RequestMapping("/supprimerMoto")
	public String supprimerMoto(@RequestParam("id") Long id, ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "5") int size) {
		motoService.deleteMotoById(id);
		Page<Moto> motos = motoService.getAllMotosParPage(page, size);
		modelMap.addAttribute("motos", motos);
		modelMap.addAttribute("pages", new int[motos.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

		return "listeMotos";
	}

	@RequestMapping("/modifierMoto")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap) {
		Moto m = motoService.getMoto(id);
		List<Model> models=motoService.getAllModels();
		modelMap.addAttribute("moto", m);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("models",models);
		return "editerMoto";
	}

	@RequestMapping("/updateMoto")
	public String updateMoto(@ModelAttribute("moto") Moto moto, @RequestParam("date") String date, ModelMap modelMap)
			throws ParseException {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		moto.setDateCreation(dateCreation);
		motoService.updateMoto(moto);
		List<Moto> motos = motoService.getAllMotos();
		modelMap.addAttribute("motos", motos);
		return "listeMotos";
	}


}
