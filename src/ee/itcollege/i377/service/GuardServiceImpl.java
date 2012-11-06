package ee.itcollege.i377.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ee.itcollege.i377.model.Guard;
import ee.itcollege.i377.repository.GuardDao;

@Service
public class GuardServiceImpl implements GuardService {
	
	@Resource
	private GuardDao guardDao;

	@Override
	public void addGuard(Guard guard) {
		guardDao.addGuard(guard);
	}

	@Override
	public List<Guard> getAllGuards() {
		return guardDao.getAllGuards();
	}

}
