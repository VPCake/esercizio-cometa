package it.objectmethod.cometadb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.cometadb.dao.IArticoloDao;
import it.objectmethod.cometadb.model.Articolo;

@Controller
public class ArticoloController {

	@Autowired
	private IArticoloDao articoloDao;

	@RequestMapping("/articoli")
	public String stampaArticoli(ModelMap model) {
		List<Articolo> articoli = new ArrayList<Articolo>();

		articoli = articoloDao.listaArticoli();

		model.addAttribute("articoli", articoli);

		return "visualizza-articoli";
	}

	@RequestMapping("/ricerca-fatta")
	public String ricercaArticoli(@RequestParam(name = "codiceRicerca", required = false) String codice,
			@RequestParam(name = "descrizioneRicerca", required = false) String descrizione, ModelMap model) {
		List<Articolo> articoli = new ArrayList<Articolo>();

		articoli = articoloDao.ricercaArt(codice, descrizione);

		model.addAttribute("articoli", articoli);

		return "visualizza-articoli";
	}

	@GetMapping("/modifica-inserisci/{id}/mod")
	public String modificaArticoli(@PathVariable("id") Integer id, ModelMap model) {
		Articolo articolo = new Articolo();
		if (id != 0) {
			articolo = articoloDao.getArticoloById(id);
		} else {
			articolo.setId(id);
		}

		model.addAttribute("articolo", articolo);

		return "modifica-articoli";
	}

	@PostMapping("/salva-articolo")
	public String modificaInserisci(@RequestParam("modificaID") Integer id,
			@RequestParam("modificaCodice") String codice, @RequestParam("modificaDescrizione") String descrizione,
			ModelMap model) {
		int check = 0;
		String conferma;

		if (id != 0) {
			check = articoloDao.modifica(id, codice, descrizione);
			conferma = "Modifica avvenuta correttamente";
		} else {
			check = articoloDao.inserisci(codice, descrizione);
			conferma = "Inserimento avvenuto correttamente";
		}

		if (check != 1) {
			conferma = "Qualcosa è andato storto";
		}

		model.addAttribute("conferma", conferma);
		return "forward:/articoli";
	}
}
