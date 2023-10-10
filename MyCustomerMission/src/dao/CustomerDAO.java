package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.CustomerVo;

public class CustomerDAO {
	private Connection connection;
	
	public CustomerDAO(String driverClass, String url, String username, String password) {
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void connectionCLose() {
		try {
			if(connection != null) connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public CustomerVo getCustomer(String cname) {
		PreparedStatement pStmt = null;
		CustomerVo customerVo = null;
		
		String sql = "select * from users where cname = ?";
		try {
			pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, cname);
			
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				customerVo = new CustomerVo(
						rs.getInt("cid"), 
						rs.getString("cname"), 
						rs.getString("cemail"), 
						rs.getString("cage"), 
						rs.getString("centrydate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(pStmt != null) pStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return customerVo;
	}
	
	public List<CustomerVo> getCustomerList() {
		PreparedStatement pStmt = null;
		List<CustomerVo> customerList = new ArrayList<>();
		
		String sql = "select * from customer order by cid";
		try {
			pStmt = connection.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				CustomerVo customerVo = new CustomerVo(
						rs.getInt("cid"), 
						rs.getString("cname"), 
						rs.getString("cemail"), 
						rs.getString("cage"), 
						rs.getString("centrydate"));
				customerList.add(customerVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStmt != null) pStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customerList;
	}
	
}
