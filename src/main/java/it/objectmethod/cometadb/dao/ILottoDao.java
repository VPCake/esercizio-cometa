package it.objectmethod.cometadb.dao;

import java.util.List;

import it.objectmethod.cometadb.model.Lotto;

public interface ILottoDao {

	public List<Lotto> listaLottiPerId(int id);

}
