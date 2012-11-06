package ee.itcollege.i377.repository;

import java.util.List;

import ee.itcollege.i377.model.Guard;

public interface GuardDao {
	
	void addGuard(Guard guard);
	List<Guard> getAllGuards();

}
