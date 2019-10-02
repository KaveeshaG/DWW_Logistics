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


import com.wms.model.LocationTransaction;
import com.wms.util.CommonConstants;
import com.wms.util.CommonUtil;
import com.wms.util.DBConnectionUtil;
import com.wms.util.QueryUtil;

public class LocationTransactionImpl implements ILocationTransactionService{
	


	public static final Logger log = Logger.getLogger(ILocationTransactionService.class.getName());
	
	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;
	
	static{
		//create table or drop if exist
		//createLocation_transfer();
	}
	
	
	public static void createLocation_transfer() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			// Drop table if already exists and as per SQL query available in

			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			
			// Create new employees table as per SQL query available in
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_LOC_TRAN_TABLE));
			

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
			
		}
		
	}

	@Override
	public void locationTransaction(LocationTransaction lt) {
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_LOCATION_TRANS_REQ));
			connection.setAutoCommit(false);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, lt.getCurrentLoc());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, lt.getCustomerId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, lt.getGRNNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, lt.getDestiLoc());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, lt.getReason());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SIX, lt.getStatus());
			
			
			preparedStatement.execute();
			connection.commit();
			
			
		} catch (Exception e) {
			
			log.log(Level.SEVERE, e.getMessage());
			
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
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
	public LocationTransaction getLocationTransactionId(String id) {
		return actionLocationTransaction(id).get(0);
	}

	@Override
	public ArrayList<LocationTransaction> getLocationTransaction() {
		return actionLocationTransaction(null);
	}
	
	
	private ArrayList<LocationTransaction> actionLocationTransaction(String id){
		
		ArrayList<LocationTransaction> locTranList = new ArrayList<LocationTransaction>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			if (id != null && !id.isEmpty()) {
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_LOCATION_TRANSACTION));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, id);
				
			}
			
			else {
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_location_Transaction));
				
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				LocationTransaction lt = new LocationTransaction();
				lt.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				lt.setCurrentLoc(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				lt.setCustomerId(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				lt.setGRNNo(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				lt.setDestiLoc(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				lt.setReason(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				lt.setStatus(resultSet.getInt(CommonConstants.COLUMN_INDEX_SEVEN));
				
				locTranList.add(lt);
				
			}
			
		} catch (Exception e) {
			
			log.log(Level.SEVERE, e.getMessage());
			
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return locTranList;
		
	}
	
	
	
	
	private ArrayList<String> getLocationTransactionIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_LOCATION_TRANS_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
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
	
	
	
	@Override
	public LocationTransaction updateLocationTransactionReq(String ID, LocationTransaction lt) {


		/*
		 * Before fetching , checks whether ID is available
		 */
		if (ID != null && !ID.isEmpty()) {
			/*
			 * Update query will be retrieved from Query.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_LOCATION_TRANS_REQ));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, lt.getCurrentLoc());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, lt.getCustomerId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, lt.getGRNNo());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, lt.getDestiLoc());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, lt.getReason());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, lt.getId());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated Location Transaction Req
		return getLocationTransactionId(ID);
		
	}



	@Override
	public void removeLocationTransactionReq(String ID) {
		
		// Before deleting check whether ID is available
		if (ID != null && !ID.isEmpty()) {
			/*
			 * Remove query will be retrieved from Query.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_LOCATION_TRANS_REQ));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, ID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
	}



	@Override
	public void adminConfirmTransaction(LocationTransaction lt) {
		
		if (lt.getId() != null && !lt.getId().isEmpty()) {
			/*
			 * Update query will be retrieved from Query.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_UPDATE_STATUS_ADMIN_CONFIRM));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, lt.getId());
				
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
		
	}



	@Override
	public void adminDeleteTransaction(LocationTransaction lt) {
		if (lt.getId() != null && !lt.getId().isEmpty()) {
			/*
			 * Update query will be retrieved from Query.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_UPDATE_STATUS_ADMIN_DELETE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, lt.getId());
				
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
		
	}
	
	
	

	
}
