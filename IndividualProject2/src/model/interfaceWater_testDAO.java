package model;

import java.sql.SQLException;
import model.Water_testBean;

public interface interfaceWater_testDAO {
	
	public int insert(Water_testBean watertest) throws SQLException;
	
	public Water_testBean findByObservatory(String observatory) throws SQLException;
	
	public int delete(String observatory)throws SQLException;	
	
	public int update(Water_testBean watertest) throws SQLException;

}
