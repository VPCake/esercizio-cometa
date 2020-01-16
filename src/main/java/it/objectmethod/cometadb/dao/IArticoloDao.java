package it.objectmethod.cometadb.dao;

import java.util.List;

import it.objectmethod.cometadb.model.Articolo;

public interface IArticoloDao {

	public List<Articolo> listaArticoli();

	public int numeroArticoli();
}
