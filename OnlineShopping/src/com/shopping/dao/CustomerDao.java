package com.shopping.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shopping.controller.DatabaseController;
import com.shopping.model.CustomerPojo;




public class CustomerDao {
	
	private DatabaseController databaseController = DatabaseController.getDatabaseController();

	public int create() {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("create table customer("
				+ "customerid int(11) NOT NULL AUTO_INCREMENT, "
				+ "customername varchar(45) NOT NULL, "
				+ "email varchar(45) NOT NULL, "
				+ "password varchar(45) NOT NULL, "
				+ "creditcardno int(11) NOT NULL, "
				+ "address varchar(45)NOT NULL, " 
				+ "PRIMARY KEY (customerid), "
				+ "UNIQUE KEY (email) "
				+ ")");
			final int result = stmt.executeUpdate();
			return result;

		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			databaseController.close(stmt, conn);
		}
	}
	public int update(CustomerPojo customer) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("update customer set customername=?,email=?,password=?,creditcardno=?,address=? where customerid=?");
			 stmt.setString(1,customer.getCustomername());
			 stmt.setString(2,customer.getEmail());
			 stmt.setString(3,customer.getPassword());
			 
			 stmt.setInt(4,customer.getCreditcardno());
			 stmt.setString(5,customer.getAddress());
			 stmt.setInt(6,customer.getCustomerid());
			
			
			final int result = stmt.executeUpdate();
			return result;

		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			databaseController.close(stmt, conn);
		}
	}

	public int delete(int customerid) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("delete from customer where customerid=?");
			stmt.setInt(1, customerid);
			final int result = stmt.executeUpdate();
			return result;

		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			databaseController.close(stmt, conn);
		}
	}

	public CustomerPojo retrieve() {
		final CustomerPojo pojo = new CustomerPojo();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("select * from customer");
			result = stmt.executeQuery();
			while (result.next()) {
				pojo.setCustomerid(result.getInt("customerid"));
				pojo.setCustomername(result.getString("customername"));
				pojo.setEmail(result.getString("email"));
				pojo.setPassword(result.getString("password"));
				pojo.setCreditcardno(result.getInt("creditcardno"));
				pojo.setAddress(result.getString("address"));

			}
			return pojo;
		} catch (final Exception e) {
			e.printStackTrace();
			return pojo;
		} finally {
			databaseController.close(result, stmt, conn);
		}
	}

}

	

