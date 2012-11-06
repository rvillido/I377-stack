package ee.itcollege.i377.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ee.itcollege.i377.model.Guard;

@Repository
public class GuardDaoImpl implements GuardDao {
	
	private static Logger log = Logger.getLogger(GuardDaoImpl.class);

	@Override
	public void addGuard(Guard guard) {
		log.debug("Adding Guard");
		//TODO
	}

	@Override
	public List<Guard> getAllGuards() {
		log.debug("Getting all guards");
		return null;
	}

}
