package ee.itcollege.i377.service;

import java.util.List;

import ee.itcollege.i377.model.Guard;

public interface GuardService {
	
	void addGuard(Guard guard);
	List<Guard> getAllGuards();

}
