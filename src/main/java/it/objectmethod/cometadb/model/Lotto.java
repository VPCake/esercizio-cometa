package it.objectmethod.cometadb.model;

public class Lotto {
	private Integer id;
	private Integer codiceLotto;
	private Integer idArticolo;
	private Integer quantita;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodiceLotto() {
		return codiceLotto;
	}

	public void setCodiceLotto(Integer codiceLotto) {
		this.codiceLotto = codiceLotto;
	}

	public Integer getIdArticolo() {
		return idArticolo;
	}

	public void setIdArticolo(Integer idArticolo) {
		this.idArticolo = idArticolo;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

}
