package service;

import model.Water_testBean;
import model.Water_testDaoJDBC;

public class Water_testService {
	Water_testDaoJDBC dao;
	public Water_testService() {
		try {
			dao=new Water_testDaoJDBC();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public int insert(Water_testBean watertest) throws Exception {
		return dao.insert(watertest);	
	}
	public int update(Water_testBean watertest) throws Exception {
		return dao.update(watertest);	
	}
	public int delete(String observatory) throws Exception {
		return dao.delete(observatory);	
	}
	public Water_testBean findByObservatory(String observatory) throws Exception {
		return dao.findByObservatory(observatory);
	}
	
}
