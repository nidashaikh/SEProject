
				
package com.shopping.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shopping.controller.DatabaseController;
import com.shopping.model.ProductPojo;




public class ProductDao {
	
	private DatabaseController databaseController = DatabaseController.getDatabaseController();
	

	public int create() {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
stmt = conn.prepareStatement("create table product("
						+ "productid int(11) NOT NULL AUTO_INCREMENT, "
						+ "productname varchar(45) NOT NULL, "
						+ "productamount int(11) NOT NULL, " + "PRIMARY KEY (productid) "
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
		public int update(ProductPojo prod) {
			Connection conn = null;
			PreparedStatement stmt = null;

			try {
				conn = DatabaseController.getConnection();
				stmt = conn.prepareStatement("update product set productname=?,productamount=? where productid=?");
				 stmt.setString(1,prod.getProductname());
				 stmt.setInt(2,prod.getProductamount());
				 stmt.setInt(3,prod.getProductid());
				   
				
				
				final int result = stmt.executeUpdate();
				return result;

			} catch (final Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				databaseController.close(stmt, conn);
			}
		}

		public int delete(int productid) {
			Connection conn = null;
			PreparedStatement stmt = null;

			try {
				conn = databaseController.getConnection();
				stmt = conn.prepareStatement("delete from product where productid=?");
				stmt.setInt(1, productid);
				final int result = stmt.executeUpdate();
				return result;

			} catch (final Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				databaseController.close(stmt, conn);
			}
		}

		public ProductPojo retrieve() {
			final ProductPojo pojo = new ProductPojo();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
			try {
				conn = databaseController.getConnection();
				stmt = conn.prepareStatement("select * from product");
				result = stmt.executeQuery();
				while (result.next()) {
					pojo.setProductid(result.getInt("productid"));
					pojo.setProductname(result.getString("productname"));
					pojo.setProductamount(result.getInt("productamount"));
					
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

		
	

		
	


