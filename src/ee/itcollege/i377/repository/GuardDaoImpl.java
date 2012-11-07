package ee.itcollege.i377.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ee.itcollege.i377.model.Guard;

@Repository
public class GuardDaoImpl implements GuardDao {
	
	private static Logger log = Logger.getLogger(GuardDaoImpl.class);
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("I377-stack");

	@Override
	public void addGuard(Guard guard) {
		log.debug("Adding Guard");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		// Create a transaction
		entityManager.getTransaction().begin();
		
		// Save the data
		entityManager.persist(guard);
		
		// Commit the transaction
		entityManager.getTransaction().commit();
		
		// Close the connection
		entityManager.close();
	}

	@Override
	public List<Guard> getAllGuards() {
		log.debug("Getting all guards");
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
		    TypedQuery<Guard> q = em.createNamedQuery("Guard.findAll", Guard.class);
		    List<Guard> guards = q.getResultList();
		    return guards;
		}
		finally {
		    em.close();
		}
	}

}
