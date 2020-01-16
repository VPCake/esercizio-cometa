package it.objectmethod.cometadb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import it.objectmethod.cometadb.dao.IArticoloDao;
import it.objectmethod.cometadb.model.Articolo;

@Controller
public class ArticoloController {

	@Autowired
	private IArticoloDao articoloDao;

	@GetMapping("/articoli")
	public String stampaArticoli(ModelMap model) {
		List<Articolo> articoli = new ArrayList<Articolo>();
		int quantitaArt;

		articoli = articoloDao.listaArticoli();
		quantitaArt = articoloDao.numeroArticoli();

		model.addAttribute("articoli", articoli);
		model.addAttribute("quantita", quantitaArt);

		return "visualizza-articoli";
	}
}
