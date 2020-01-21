package it.objectmethod.cometadb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.objectmethod.cometadb.dao.ILottoDao;
import it.objectmethod.cometadb.model.Lotto;

@Controller
public class LottoController {

	@Autowired
	private ILottoDao lottoDao;

	@GetMapping("/lotti/{id}/show")
	public String stampaLotti(@PathVariable("id") Integer id, ModelMap model) {
		List<Lotto> lotti = new ArrayList<Lotto>();

		lotti = lottoDao.listaLottiPerId(id);

		model.addAttribute("lotti", lotti);
		return "visualizza-lotti";
	}
}
