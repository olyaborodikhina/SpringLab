package lab.dao;

import lab.domain.Country;
import lab.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by omsk17 on 12/12/2016.
 */
public class HsqlCountryDao extends JdbcDaoSupport implements CountryDao {


    private static Log log = LogFactory.getLog(HsqlUserDao.class);

    @Override
    public void insert(Country country) {

        if (country != null) {
            log.debug( "Processing country: " + country);
            this.getJdbcTemplate().update(
                    "insert into country (namecountry, codecountry) values (?, ?)",
                   country.getNameCountry(), country.getCodeCountry());

        } else {
            log.debug("Domain country is null!");
        }
    }

    @Override
    public Country select(int id) {

        Country country = null;

        if (id > 0) {
            country = this.getJdbcTemplate().queryForObject(
                    "select id, namecountry, codecountry from country where id = ?",
                    new Object[] { id }, new HsqlCountryDao.CountryMapper());
        }
        log.debug("Receidved country: " + country);

        return country;
    }

    @Override
    public List< Country> selectAll() {
        return this.getJdbcTemplate().query(
                "select id, namecountry, codecountry from country"
                , new HsqlCountryDao.CountryMapper());
    }

    private static final class CountryMapper implements RowMapper<Country> {

        public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
            Country country = new Country();
            country.setId(rs.getInt("id"));
            country.setNameCountry(rs.getString("nameCountry"));
            country.setCodeCountry(rs.getString("codeCountry"));
            return country;
        }
    }
}
