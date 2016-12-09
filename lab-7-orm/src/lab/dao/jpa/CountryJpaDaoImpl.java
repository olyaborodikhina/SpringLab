package lab.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lab.dao.CountryDao;
import lab.model.Country;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

	@Override
	public void save(Country country) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(country);
		em.getTransaction().commit();
		if (em != null) {
			em.close();
			System.out.println("kdm");
		}
	}

	@Override
	public List<Country> getAllCountries() {
		EntityManager em = emf.createEntityManager();
		List<Country> allCountry = null;
		if(em != null) {
			em.getTransaction().begin();
			allCountry = em.createQuery("select c from Country c", Country.class).getResultList();
			em.getTransaction().commit();
			em.close();
		}
		return allCountry;
	}

	@Override
	public Country getCountryByName(String name) {
		Country country = null;
		EntityManager em = emf.createEntityManager();
		if(em != null) {
			//em.getTransaction().begin();
			country = em.createQuery("select c from Country c where c.name like:name", Country.class)
					.setParameter("name", name)
					.getSingleResult();
			//em.getTransaction().commit();
			em.close();
		}

		return country;
	}

}
