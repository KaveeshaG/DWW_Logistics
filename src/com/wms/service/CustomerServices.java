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

import com.wms.model.CustomerAccount;
import com.wms.util.CommonConstants;
import com.wms.util.DBConnectionUtil;
import com.wms.util.QueryUtil;

public class CustomerServices implements ICustomer {
	public static final Logger log = Logger.getLogger(CustomerServices.class.getName());

	private static Connection connection;

//	private static Statement statement;

	private static PreparedStatement ps;

	private static ResultSet rs;

	public CustomerServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCustomer(CustomerAccount account) {
		// TODO Auto-generated method stub

		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_CUSTOMETR_TABLE));
			connection.setAutoCommit(false);

			ps.setString(1, account.getCustomerName());
			ps.setString(2, account.getType());
			ps.setString(3, account.getEmail());
			ps.setString(4, account.getMobile());
			ps.setString(5, account.getPassword());
			ps.setString(6, account.getNic());

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
	public ArrayList<CustomerAccount> getCustomerList() {

		ArrayList<CustomerAccount> list = new ArrayList<CustomerAccount>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CUSTOMER_TABLE));
			rs = ps.executeQuery();

			while (rs.next()) {

				CustomerAccount customer = new CustomerAccount();
				customer.setCustomerId(Integer.parseInt(rs.getString(1)));
				customer.setCustomerName(rs.getString(2));
				customer.setType(rs.getString(3));
				customer.setEmail(rs.getString(4));
				customer.setMobile(rs.getString(5));
				customer.setPassword(rs.getString(6));
				customer.setNic(rs.getString(7));

				list.add(customer);

			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {

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
	public void customerAccountDeleteById(String itemNo) {
		// TODO Auto-generated method stub
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_FROM_CUSTOMER));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, itemNo);

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
	public CustomerAccount updateCustomerById(int CustomerID, CustomerAccount customer) {
		


	
		if (CustomerID + "" != null && !((CustomerID + "").isEmpty())) {
		
			try {
				connection = DBConnectionUtil.getDBConnection();
				ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_CUSTOMER_ITEM));
				ps.setString(1, customer.getCustomerName());
				ps.setString(2, customer.getType());
				ps.setString(3, customer.getNic());
				ps.setString(4, customer.getEmail());
				ps.setString(5, customer.getMobile());
				ps.setInt(6, customer.getCustomerId());
				ps.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
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
		// Get the updated employee
		return getCustomerByID(CustomerID);

	}

	@Override
	public CustomerAccount getCustomerByID(int CustomerID) {

		return actionOnCustomerAccount(CustomerID).get(0);
	}

	@Override
	public ArrayList<CustomerAccount> getCustomerAccount() {

		return actionOnCustomerAccount(0);
	}

	private ArrayList<CustomerAccount> actionOnCustomerAccount(int CustomerID) {

		ArrayList<CustomerAccount> customerList = new ArrayList<CustomerAccount>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			if (CustomerID == 0) {

				ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CUSTOMER_TABLE));
			}

			else {
				ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CUSTOMER_BY_ID));
				ps.setInt(CommonConstants.COLUMN_INDEX_ONE, CustomerID);
			}
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				CustomerAccount customer = new CustomerAccount();
				customer.setCustomerId(resultSet.getInt(1));
				customer.setCustomerName(resultSet.getString(2));
				customer.setType(resultSet.getString(3));
				customer.setEmail(resultSet.getString(4));
				customer.setMobile(resultSet.getString(5));
				customer.setPassword(resultSet.getString(6));
				customer.setNic(resultSet.getString(7));

				customerList.add(customer);
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

		return customerList;
	}

	@Override
	public boolean isCustomerAvailable(int CustomerID) {

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CHECK_CUSTOMETR_AVAILABILITY));
			ps.setInt(1, CustomerID);

			ResultSet rs = ps.executeQuery();

			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
	public ArrayList<CustomerAccount> searchCustomerById(String txt) {

		ArrayList<CustomerAccount> list = new ArrayList<CustomerAccount>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SEARCH_CUSTOMETR_BY_ID));
			ps.setString(1, txt);
			rs = ps.executeQuery();

			while (rs.next()) {

				CustomerAccount customer = new CustomerAccount();
				customer.setCustomerId(Integer.parseInt(rs.getString(1)));
				customer.setCustomerName(rs.getString(2));
				customer.setType(rs.getString(3));
				customer.setEmail(rs.getString(4));
				customer.setMobile(rs.getString(5));
				customer.setPassword(rs.getString(6));
				customer.setNic(rs.getString(7));

				list.add(customer);

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
	public ArrayList<CustomerAccount> searchCustomerByName(String txt) {

		ArrayList<CustomerAccount> list = new ArrayList<CustomerAccount>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SEARCH_CUSTOMETR_BY_NAME));
			ps.setString(1, "%" + txt + "%");
			rs = ps.executeQuery();

			while (rs.next()) {

				CustomerAccount customer = new CustomerAccount();
				customer.setCustomerId(Integer.parseInt(rs.getString(1)));
				customer.setCustomerName(rs.getString(2));
				customer.setType(rs.getString(3));
				customer.setEmail(rs.getString(4));
				customer.setMobile(rs.getString(5));
				customer.setPassword(rs.getString(6));
				customer.setNic(rs.getString(7));

				list.add(customer);

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
	public ArrayList<CustomerAccount> searchCustomerByType(String txt) {

		ArrayList<CustomerAccount> list = new ArrayList<CustomerAccount>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SEARCH_CUSTOMETR_BY_TYPE));
			ps.setString(1, "%" + txt + "%");
			rs = ps.executeQuery();

			while (rs.next()) {

				CustomerAccount customer = new CustomerAccount();
				customer.setCustomerId(Integer.parseInt(rs.getString(1)));
				customer.setCustomerName(rs.getString(2));
				customer.setType(rs.getString(3));
				customer.setEmail(rs.getString(4));
				customer.setMobile(rs.getString(5));
				customer.setPassword(rs.getString(6));
				customer.setNic(rs.getString(7));

				list.add(customer);

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
	public ArrayList<CustomerAccount> searchCustomerByEmail(String txt) {

		ArrayList<CustomerAccount> list = new ArrayList<CustomerAccount>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SEARCH_CUSTOMETR_BY_EMAIL));
			ps.setString(1, "%" + txt + "%");
			rs = ps.executeQuery();

			while (rs.next()) {

				CustomerAccount customer = new CustomerAccount();
				customer.setCustomerId(Integer.parseInt(rs.getString(1)));
				customer.setCustomerName(rs.getString(2));
				customer.setType(rs.getString(3));
				customer.setEmail(rs.getString(4));
				customer.setMobile(rs.getString(5));
				customer.setPassword(rs.getString(6));
				customer.setNic(rs.getString(7));

				list.add(customer);

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
	public ArrayList<CustomerAccount> searchCustomerByMobile(String txt) {

		ArrayList<CustomerAccount> list = new ArrayList<CustomerAccount>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SEARCH_CUSTOMETR_BY_MOBILE));
			ps.setString(1, "%" + txt + "%");
			rs = ps.executeQuery();

			while (rs.next()) {

				CustomerAccount customer = new CustomerAccount();
				customer.setCustomerId(Integer.parseInt(rs.getString(1)));
				customer.setCustomerName(rs.getString(2));
				customer.setType(rs.getString(3));
				customer.setEmail(rs.getString(4));
				customer.setMobile(rs.getString(5));
				customer.setPassword(rs.getString(6));
				customer.setNic(rs.getString(7));

				list.add(customer);

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
