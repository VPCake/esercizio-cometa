package it.objectmethod.cometadb.model;

public class Articolo {
	private Integer id;
	private String codice;
	private String descrizione;
	private Integer quantitaTotale;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getQuantitaTotale() {
		return quantitaTotale;
	}

	public void setQuantitaTotale(Integer quantitaTotale) {
		this.quantitaTotale = quantitaTotale;
	}

}
