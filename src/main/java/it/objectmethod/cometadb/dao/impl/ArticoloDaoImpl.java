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
		String sql = "SELECT * FROM cometa_easy.lotti";
		BeanPropertyRowMapper<Articolo> rm = new BeanPropertyRowMapper<Articolo>(Articolo.class);
		articoli = getJdbcTemplate().query(sql, new Object[] {}, rm);

		return articoli;
	}

	@Override
	public int numeroArticoli() {
		int numeroArt;
		String sql = "SELECT sum(quantita) FROM cometa_easy.lotti";

		numeroArt = getJdbcTemplate().queryForObject(sql, Integer.class);
		
		return numeroArt;
	}
}
