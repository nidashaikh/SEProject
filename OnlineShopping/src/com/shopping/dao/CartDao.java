package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shopping.controller.DatabaseController;
import com.shopping.model.CartPojo;


public class CartDao {
	private DatabaseController databaseController = DatabaseController.getDatabaseController();

	public int create() {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("create table cart("
			    + "cart_no int(11) NOT NULL, "
				+ "productid int(11) NOT NULL, "
				+ "customerid int(11), "
				+ "FOREIGN KEY (customerid) REFERENCES customer(customerid), "
				+ "FOREIGN KEY (productid) REFERENCES product(productid) "
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
	public int update(CartPojo cart) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("update cart set customerid=?,productid=? where cart_no=?");
			 stmt.setInt(1,cart.getCustomerid());
			 stmt.setInt(2,cart.getProductid());
			 stmt.setInt(3,cart.getCart_no());
			
			
			final int result = stmt.executeUpdate();
			return result;

		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			databaseController.close(stmt, conn);
		}
	}

	public int delete(int cart_no) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("delete from cart where cart_no=?");
			stmt.setInt(1, cart_no);
			final int result = stmt.executeUpdate();
			return result;

		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			databaseController.close(stmt, conn);
		}
	}

	public CartPojo retrieve() {
		final CartPojo pojo = new CartPojo();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("select * from cart");
			result = stmt.executeQuery();
			while (result.next()) {
				pojo.setCart_no(result.getInt("cart_no"));
				pojo.setCustomerid(result.getInt("customerid"));
				pojo.setProductid(result.getInt("productid"));
		
				

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



