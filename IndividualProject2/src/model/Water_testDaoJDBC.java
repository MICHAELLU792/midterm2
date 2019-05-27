package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.interfaceWater_testDAO;
import model.Water_testBean;

public class Water_testDaoJDBC implements interfaceWater_testDAO {	 
	DataSource ds=null;
	Connection conn = null;

	public  Water_testDaoJDBC() throws Exception {	
		Context ctx = new InitialContext();	
		ds=(DataSource)ctx.lookup("java:comp/env/DB01/water_testing");
	}
	

	@Override
	public int insert(Water_testBean watertest) throws SQLException {	
		String INSERT_STMT = "insert into water_testing values(?,?,?,?,?,?,?,?)";
		int updateCount = 0;
		Connection conn=ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(INSERT_STMT);
		pstmt.setString(1, watertest.getName());
		pstmt.setString(2, watertest.getObservatory());
		pstmt.setString(3, watertest.getTestdate());
		pstmt.setString(4, watertest.getLevel());
		pstmt.setDouble(5, watertest.getRPI());
		pstmt.setDouble(6, watertest.getDO());
		pstmt.setString(7, watertest.getAmmonia());
		pstmt.setDouble(8, watertest.getSS());
		updateCount = pstmt.executeUpdate();
		conn.close();
		return updateCount;
	}

	@Override
	public Water_testBean findByObservatory(String observatory) throws SQLException {		
		Water_testBean obv= null;
		Connection conn=ds.getConnection();
		String GET_ONE_STMT = "select name,observatory,testdate,level,RPI,DO,Ammonia,SS from water_testing where observatory=?";
		PreparedStatement pstmt = conn.prepareStatement(GET_ONE_STMT);
		pstmt.setString(1,observatory);
		ResultSet rs = pstmt.executeQuery();		
		while (rs.next()) {
			obv=new Water_testBean();
			obv.setName(rs.getString("name"));
			obv.setObservatory(rs.getString("observatory"));				
			obv.setTestdate(rs.getString("testdate"));
			obv.setLevel(rs.getString("level"));
			obv.setRPI(rs.getDouble("RPI"));
			obv.setDO(rs.getDouble("DO"));
			obv.setAmmonia(rs.getString("Ammonia"));
			obv.setSS(rs.getDouble("SS"));
		}
		conn.close();
		return obv;
	}


	@Override
	public int delete(String observatory) throws SQLException {
		int updateCount=0;
		Connection conn=ds.getConnection();
		String DELETE_STMT="delete water_testing where observatory=?";
		PreparedStatement pstmt = conn.prepareStatement(DELETE_STMT);
		pstmt.setString(1, observatory);
		updateCount=pstmt.executeUpdate();
		conn.close();
		return updateCount;
	}


	@Override
	public int update(Water_testBean watertest) throws SQLException {
		int updateCount=0;
		Connection conn=ds.getConnection();
		String UPDATE_STMT ="update water_testing set name=?,testdate=?,level=?,RPI=?,DO=?,Ammonia=?,SS=? where observatory=?";
		PreparedStatement pstmt = conn.prepareStatement(UPDATE_STMT);
		pstmt.setString(1, watertest.getName());
		pstmt.setString(2, watertest.getTestdate());
		pstmt.setString(3, watertest.getLevel());
		pstmt.setDouble(4, watertest.getRPI());
		pstmt.setDouble(5, watertest.getDO());
		pstmt.setString(6, watertest.getAmmonia());
		pstmt.setDouble(7, watertest.getSS());
		pstmt.setString(8, watertest.getObservatory());
		updateCount=pstmt.executeUpdate();	
		conn.close();
		return updateCount;
	}

}
