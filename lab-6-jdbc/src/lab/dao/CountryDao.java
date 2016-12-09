package lab.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lab.model.Country;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class CountryDao extends JdbcDaoSupport {
	private static final String LOAD_COUNTRIES_SQL = "insert into country (name, code_name) values ";

	private static final String GET_ALL_COUNTRIES_SQL = "select * from country";
	private static final String GET_COUNTRIES_BY_NAME_SQL = "select * from country where name like :name";
	private static final String GET_COUNTRY_BY_NAME_SQL = "select * from country where name = '";
	private static final String GET_COUNTRY_BY_CODE_NAME_SQL = "select * from country where code_name = '";

	private static final String UPDATE_COUNTRY_NAME_SQL_1 = "update country SET name='";
	private static final String UPDATE_COUNTRY_NAME_SQL_2 = " where code_name='";



	private static final CountryRowMapper COUNTRY_ROW_MAPPER = new CountryRowMapper();

	public List<Country> getCountryListStartWith(String name) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				getDataSource());
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"name", name + "%");
		return namedParameterJdbcTemplate.query(GET_COUNTRIES_BY_NAME_SQL,
				sqlParameterSource, COUNTRY_ROW_MAPPER);
	}

	public List<Country> getCountryList(){
		return getJdbcTemplate().query(GET_ALL_COUNTRIES_SQL,COUNTRY_ROW_MAPPER);
	}

	public void updateCountryName(String codeName, String newCountryName) {
		final Map<String,String> params = new HashMap<>();
		params.put("newName", newCountryName);
		params.put("code", codeName);
		new NamedParameterJdbcTemplate(getDataSource()).update(
				"update country SET name = :newName where code_name = :code",
				params
		);

	}


	public Country getCountryByCodeName(String codeName) {

		String sql = "select * from country where code_name = ?";
		return getJdbcTemplate().queryForObject(sql, new Object[]{codeName}, COUNTRY_ROW_MAPPER);
	}


}
