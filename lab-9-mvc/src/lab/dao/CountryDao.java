package lab.dao;

import lab.domain.Country;

import java.util.List;

/**
 * Created by omsk17 on 12/12/2016.
 */
public interface CountryDao {


        public void insert(Country country);

        public Country select(int id);

        public List<Country> selectAll();


}
