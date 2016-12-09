package lab.dao.jpa;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Transactional
public class AbstractJpaDao {

	protected EntityManagerFactory emf;

	public AbstractJpaDao() {
		super();
	}

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

}