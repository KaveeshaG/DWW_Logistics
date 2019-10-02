package com.wms.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


import com.wms.model.SupplierAcount;
import com.wms.model.SupplierProduct;
import com.wms.util.CommonConstants;
import com.wms.util.CommonFunctions;
import com.wms.util.DBConnectionUtil;
import com.wms.util.QueryUtil;

public class SupplierServices implements Supplier {

	public static final Logger log = Logger.getLogger(SupplierServices.class.getName());

	private static Connection connection;

	private static Statement statement;

	private static PreparedStatement ps;

	private static ResultSet rs;
	
	
	/*static{
		//create table or drop if exist
		createTables();
	}
	
	public static void createTables() {
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE_SUPPLIER_PRODUCT));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE_SUPPLIER_ACCOUNT));

			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE_SUPPLIER_ACCOUNT));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE_SUPPLIER_PRODUCT));
			
			
			

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		
	}
	*/
	
	
	
	
	
	
	

	@Override
	public void addProduct(SupplierProduct product) {
		// TODO Auto-generated method stub
		String id = CommonFunctions.generateIDs(getProductTableID(), CommonConstants.PRODUCT_PREFIX);
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_PRODUCT_TABLE));
			connection.setAutoCommit(false);

			product.setProductId(id);
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, product.getSupplierId());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, product.getProductId());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, product.getProductName());
			ps.setInt(CommonConstants.COLUMN_INDEX_FOUR, product.getQty());
			ps.setDouble(CommonConstants.COLUMN_INDEX_FIVE, product.getProPrice());
			ps.setString(CommonConstants.COLUMN_INDEX_SIX, product.getWarranty());
			ps.setString(CommonConstants.COLUMN_INDEX_SEVEN, product.getDescription());
			ps.setString(CommonConstants.COLUMN_INDEX_EIGHT, product.getImageName());
			
			ps.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void addSuppliers(SupplierAcount supplier) {
		// TODO Auto-generated method stub
		String id = CommonFunctions.generateIDs(getSupplierTableID(), CommonConstants.SUPPLIER_PREFIX);
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_SUPPLIERS_TABLE));
			connection.setAutoCommit(false);

			supplier.setSupplierId(id);
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, supplier.getSupplierId());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, supplier.getUserName());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, supplier.getPassword());
			ps.setString(CommonConstants.COLUMN_INDEX_FOUR, supplier.getName());
			ps.setString(CommonConstants.COLUMN_INDEX_FIVE, supplier.getAddress());
			ps.setString(CommonConstants.COLUMN_INDEX_SIX, supplier.getEmail());
			ps.setString(CommonConstants.COLUMN_INDEX_SEVEN, supplier.getContactNo());
			ps.setString(CommonConstants.COLUMN_INDEX_EIGHT, supplier.getReview());
			
			ps.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}
	
	
	
	
	
	
	
	
	public void deleteAllProductBySupID(String supID) {
		// TODO Auto-generated method stub
		
		try {

			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_PRODUCT_BY_SUP_ID));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, supID);
			ps.execute();

			

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}
	
	
	
	public void deleteSupplier() {
		// TODO Auto-generated method stub
		
		try {

			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_SUPPLIER_TABLE));
			

			

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}
	
	
	
	
	public void deleteProductById(String productID) {
		// TODO Auto-generated method stub
		
		try {

			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_SUPPLIER_PRODUCT_BY_ID));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, productID);
			ps.execute();

			

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}
	
	
	
	public void deleteSupplierAccounttById(String supplierID) {
		// TODO Auto-generated method stub
		
		try {

			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_SUPPLIER_ACCOUNTS_BY_ID));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, supplierID);
			ps.execute();

			

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}
	
	
	
	
	
	
	private ArrayList<String> getProductTableID() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SUPLIER_PRODUCT_TABLE_ENTRY_COUNT));
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
	
	
	
	private ArrayList<String> getSupplierTableID() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SUPLIER_ACCOUNT_TABLE_ENTRY_COUNT));
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
	
	
	
	public ArrayList<SupplierAcount> getSupplierTableList() {

		ArrayList<SupplierAcount> list = new ArrayList<SupplierAcount>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SUPPLIER_TABLE));
			rs = ps.executeQuery();

			while (rs.next()) {

				SupplierAcount supplier = new SupplierAcount();
				supplier.setSupplierId(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				supplier.setName(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				supplier.setUserName(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				supplier.setPassword(rs.getString(CommonConstants.COLUMN_INDEX_FOUR));
				supplier.setAddress(rs.getString(CommonConstants.COLUMN_INDEX_FIVE));
				supplier.setEmail(rs.getString(CommonConstants.COLUMN_INDEX_SIX));
				supplier.setContactNo(rs.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				supplier.setReview(rs.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				
				
				
				list.add(supplier);

			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return list;

	}
	
	
	
	
	
	
	
	
	public ArrayList<SupplierProduct> getProductTableList(String supID) {

		ArrayList<SupplierProduct> list = new ArrayList<SupplierProduct>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SUPPLIER_PRODUCTS));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, supID);
			rs = ps.executeQuery();

			while (rs.next()) {

				SupplierProduct product = new SupplierProduct();
				product.setSupplierId(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				product.setProductId(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				product.setProductName(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				product.setQty(Integer.parseInt(rs.getString(CommonConstants.COLUMN_INDEX_FOUR)));
				product.setProPrice(Double.parseDouble(rs.getString(CommonConstants.COLUMN_INDEX_FIVE)));
				product.setWarranty(rs.getString(CommonConstants.COLUMN_INDEX_SIX));
				product.setDescription(rs.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				product.setImageName(rs.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				
				
				
				list.add(product);

			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return list;

	}
	
	@Override
	public void updateSupplierAccountByID(SupplierAcount acount) {
		// TODO Auto-generated method stub

				try {

					connection = DBConnectionUtil.getDBConnection();

					ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_SUPPLIER_ACCOUNT));
					connection.setAutoCommit(false);

					
					ps.setString(CommonConstants.COLUMN_INDEX_ONE, acount.getUserName());
					ps.setString(CommonConstants.COLUMN_INDEX_TWO, acount.getPassword());
					ps.setString(CommonConstants.COLUMN_INDEX_THREE, acount.getName());
					ps.setString(CommonConstants.COLUMN_INDEX_FOUR, acount.getAddress());
					ps.setString(CommonConstants.COLUMN_INDEX_FIVE, acount.getEmail());
					ps.setString(CommonConstants.COLUMN_INDEX_SIX, acount.getContactNo());
					ps.setString(CommonConstants.COLUMN_INDEX_SEVEN, acount.getReview());
					ps.setString(CommonConstants.COLUMN_INDEX_EIGHT, acount.getSupplierId());
					ps.execute();
					connection.commit();

				} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
					log.log(Level.SEVERE, e.getMessage());
				} finally {
					/*
					 * Close prepared statement and database connectivity at the end of transaction
					 */
					try {
						if (ps != null) {
							ps.close();
						}
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						log.log(Level.SEVERE, e.getMessage());
					}
				}
	}
	
	
	
	public SupplierAcount getSupplierDetailsByID(String supplierID) {
		
		
		SupplierAcount acount =  new SupplierAcount();
		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SUPPLIER_DETAILS_BY_ID));
			ps.setString(1, supplierID);
			rs = ps.executeQuery();

			while (rs.next()) {

				
				acount.setSupplierId(rs.getString(1));
				acount.setName(rs.getString(2));
				acount.setUserName(rs.getString(3));
				acount.setPassword(rs.getString(4));
				acount.setAddress(rs.getString(5));
				acount.setEmail(rs.getString(6));
				acount.setContactNo(rs.getString(7));
				acount.setReview(rs.getString(8));
				
				
				

			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return acount;
	}














	@Override
	public SupplierProduct getProductByID(String productID) {
		// TODO Auto-generated method stub
		SupplierProduct product = new SupplierProduct();
		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PRODUCT_BY_ID));
			ps.setString(1, productID);
			rs = ps.executeQuery();

			while (rs.next()) {

				
				product.setSupplierId(rs.getString(1));
				product.setProductId(rs.getString(2));
				product.setProductName(rs.getString(3));
				product.setQty(Integer.parseInt(rs.getString(4)));
				product.setProPrice(Float.parseFloat(rs.getString(5)));
				product.setWarranty(rs.getString(6));
				product.setDescription(rs.getString(7));
				product.setImageName(rs.getString(8));
				
				
				

			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return product;
	}


	@Override
	public void updateProductByID(String productID, SupplierProduct product) {
		// TODO Auto-generated method stub
		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_PRODUCT_BY_ID));
			ps.setString(1, product.getProductName());
			ps.setInt(2, product.getQty());
			ps.setString(3, product.getWarranty());
			ps.setString(4, product.getDescription());
			ps.setString(5, product.getImageName());
			ps.setString(6, productID);
			ps.execute();

			

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		
	}














	@Override
	public ArrayList<SupplierProduct> getAllSuppliersproduct() {
		// TODO Auto-generated method stub
		ArrayList<SupplierProduct> list = new ArrayList<SupplierProduct>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ALL_SUPPLIERS_PRODUCTS));
			rs = ps.executeQuery();

			while (rs.next()) {

				SupplierProduct product = new SupplierProduct();
				product.setSupplierId(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				product.setProductId(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				product.setProductName(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				product.setQty(Integer.parseInt(rs.getString(CommonConstants.COLUMN_INDEX_FOUR)));
				product.setProPrice(Double.parseDouble(rs.getString(CommonConstants.COLUMN_INDEX_FIVE)));
				product.setWarranty(rs.getString(CommonConstants.COLUMN_INDEX_SIX));
				product.setDescription(rs.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				product.setImageName(rs.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				
				
				
				list.add(product);

			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return list;
	}
}
