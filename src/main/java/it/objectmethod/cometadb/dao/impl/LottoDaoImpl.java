package it.objectmethod.cometadb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import it.objectmethod.cometadb.dao.ILottoDao;
import it.objectmethod.cometadb.model.Lotto;

@Service
public class LottoDaoImpl extends NamedParameterJdbcDaoSupport implements ILottoDao {

	@Autowired
	public LottoDaoImpl(DataSource dataSource) {
		super();
		setDataSource(dataSource);
	}

	@Override
	public List<Lotto> listaLottiPerId(int id) {
		List<Lotto> lotti = new ArrayList<Lotto>();
		String sql = "SELECT * FROM cometa_easy.lotti WHERE id_articolo=?;";
		BeanPropertyRowMapper<Lotto> rm = new BeanPropertyRowMapper<Lotto>(Lotto.class);
		lotti = getJdbcTemplate().query(sql, new Object[] { id }, rm);

		return lotti;
	}
}
