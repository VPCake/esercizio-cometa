package it.objectmethod.cometadb.dao;

import java.util.List;

import it.objectmethod.cometadb.model.Articolo;

public interface IArticoloDao {

	public List<Articolo> listaArticoli();

	List<Articolo> ricercaArt(String codice, String descrizione);

	Articolo getArticoloById(int id);

	Integer nuovoId();

	int modifica(int id, String codice, String descrizione);

	int inserisci(String codice, String descrizione);

}
