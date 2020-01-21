package it.objectmethod.cometadb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import it.objectmethod.cometadb.dao.IArticoloDao;
import it.objectmethod.cometadb.model.Articolo;

@Service
public class ArticoloDaoImpl extends NamedParameterJdbcDaoSupport implements IArticoloDao {

	@Autowired
	public ArticoloDaoImpl(DataSource dataSource) {
		super();
		setDataSource(dataSource);
	}

	@Override
	public List<Articolo> listaArticoli() {
		List<Articolo> articoli = new ArrayList<Articolo>();
		String sql = "select a.id id, a.codice codice, a.descrizione descrizione,sum(l.quantita) quantita_totale "
				+ "from articoli a join lotti l on a.id=l.id_articolo group by a.id;";
		BeanPropertyRowMapper<Articolo> rm = new BeanPropertyRowMapper<Articolo>(Articolo.class);
		articoli = getJdbcTemplate().query(sql, new Object[] {}, rm);

		return articoli;
	}

	@Override
	public List<Articolo> ricercaArt(String codice, String descrizione) {
		String codiceRicerca = "%" + codice + "%";
		String descrRicerca = "%" + descrizione + "%";
		List<Articolo> articoli = new ArrayList<Articolo>();
		String sql = "select a.id id, a.codice codice, a.descrizione descrizione,sum(l.quantita) quantita_totale "
				+ "from articoli a join lotti l on a.id=l.id_articolo where a.codice like ? and a.descrizione like ? group by a.id;";
		BeanPropertyRowMapper<Articolo> rm = new BeanPropertyRowMapper<Articolo>(Articolo.class);
		articoli = getJdbcTemplate().query(sql, new Object[] { codiceRicerca, descrRicerca }, rm);
		return articoli;
	}

	@Override
	public Articolo getArticoloById(int id) {
		Articolo articolo = new Articolo();
		String sql = "select a.id id, a.codice codice, a.descrizione descrizione,sum(l.quantita) quantita_totale "
				+ "from articoli a join lotti l on a.id=l.id_articolo where a.id=? group by a.id;";
		BeanPropertyRowMapper<Articolo> rm = new BeanPropertyRowMapper<Articolo>(Articolo.class);
		articolo = getJdbcTemplate().queryForObject(sql, new Object[] { id }, rm);
		return articolo;
	}

	@Override
	public Integer nuovoId() {
		Integer max;
		String sql = "SELECT max(id) FROM articoli;";
		max = getJdbcTemplate().queryForObject(sql, new Object[] {}, Integer.class);
		max++;
		return max;
	}

	@Override
	public int modifica(int id, String codice, String descrizione) {

		int rows = 0;
		String queryMod = "UPDATE articoli SET id = ?, codice= ?, descrizione=? WHERE id=?";
		rows = getJdbcTemplate().update(queryMod, new Object[] { id, codice, descrizione, id });

		return rows;
	}

	@Override
	public int inserisci(String codice, String descrizione) {

		int rows = 0;
		String queryMod = "INSERT INTO articoli (codice, descrizione) VALUES (?, ?)";
		rows = getJdbcTemplate().update(queryMod, new Object[] { codice, descrizione });

		return rows;
	}

}
