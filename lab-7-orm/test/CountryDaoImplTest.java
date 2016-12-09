import static org.junit.Assert.assertEquals;

import java.util.List;

import lab.dao.CountryDao;
import lab.model.Country;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class CountryDaoImplTest {

//	private static Log log = LogFactory.getLog(CountryDaoImplTest.class);

	private Country exampleCountry = new Country("Australia", "AU");

	@Autowired
	private CountryDao countryDao;

	@Test
	@DirtiesContext
	public void testSaveCountry() {
		countryDao.save(exampleCountry);
		List<Country> countryList = countryDao.getAllCountries();
		assertEquals(1, countryList.size());
		assertEquals(exampleCountry, countryList.get(0));
	}

	@Test
	@DirtiesContext
	public void testGtAllCountries() {
		countryDao.save(new Country("Canada", "CA"));
		countryDao.save(exampleCountry);

		List<Country> countryList = countryDao.getAllCountries();
		assertEquals(2, countryList.size());
	}

	@Test
	@DirtiesContext
	public void testGetCountryByName() {
		countryDao.save(new Country("Australia", "AU"));
		Country country = countryDao.getCountryByName("Australia");
		assertEquals(exampleCountry, country);
	}

}
