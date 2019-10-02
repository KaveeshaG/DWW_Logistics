package com.wms.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.mysql.cj.jdbc.CallableStatement;
import com.sun.xml.internal.bind.v2.model.annotation.FieldLocatable;
import com.wms.model.Inventory;
import com.wms.model.InventoryNotifications;
import com.wms.model.PurchaseOrderDetails;
import com.wms.model.PurchaseOrderHead;
import com.wms.model.Quotation;
import com.wms.model.QuotationDetails;
import com.wms.util.CommonConstants;
import com.wms.util.CommonFunctions;
import com.wms.util.DBConnectionUtil;
import com.wms.util.QueryUtil;

public class InventoryManagerServices implements IInventoryManager {

	public static final Logger log = Logger.getLogger(InventoryManagerServices.class.getName());

	private static Connection connection;

	private static Statement statement;

	private static PreparedStatement ps;

	private static ResultSet rs;
	
	CallableStatement stmt = null;
	
	/*static{
		//create table or drop if exist
		createTables();
	}
	
	
	public static void createTables() {
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_INVENTORY_TABLE));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_INVENTORY_TABLE));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_PROCEDURE_TOTAODAY));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_PROCEDURE_GET_REMAINING_DAYS));
			

			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_CREATE_PROCEDURE_TOTAODAY));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_CREATE_PROCEDURE_GET_REMAININNG_DAYS));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_QUOTATION_DETAILS_TABLE));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_QUOTATION_TABLE));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_PURCHASE_ORDER_DETAILS_TABLE));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_PURCHASE_ORDER_TABLE));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_PURCHASE_ORDER_TABLE));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_PURCHASE_ORDER_DETAILS_TABLE));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_QUOTATION_TABLE));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_QUOTATION_DETAILS_TABLE));
			
			

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		
		
		
	}*/
	
	
	
	
	
	@Override
	public void addItems(Inventory inventory) {
		// TODO Auto-generated method stub
				String itemNo = CommonFunctions.generateIDs(getInvetoryTableID(), CommonConstants.INVENRTORY_PREFIX);

				try {

					connection = DBConnectionUtil.getDBConnection();

					ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_INVENTORY_TABLE));
					connection.setAutoCommit(false);

					inventory.setItemNo(itemNo);
					ps.setString(CommonConstants.COLUMN_INDEX_ONE, inventory.getItemNo());
					ps.setString(CommonConstants.COLUMN_INDEX_TWO, inventory.getName());
					ps.setString(CommonConstants.COLUMN_INDEX_THREE, inventory.getDescription());
					ps.setString(CommonConstants.COLUMN_INDEX_FOUR, inventory.getWarrentyYear());
					ps.setString(CommonConstants.COLUMN_INDEX_FIVE, inventory.getAddedDate());
					ps.setString(CommonConstants.COLUMN_INDEX_SIX, inventory.getLocation());
					ps.setString(CommonConstants.COLUMN_INDEX_SEVEN, inventory.getStatus());
					ps.setString(CommonConstants.COLUMN_INDEX_EIGHT, inventory.getOwner());
					ps.setString(CommonConstants.COLUMN_INDEX_NINE, inventory.getType());
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
	
	private ArrayList<String> getInvetoryTableID() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_INVENTORY_TABLE_ENTRY_COUNT));
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
	
	
	@Override
	public ArrayList<Inventory> getInventoryList(String type) {

		ArrayList<Inventory> list = new ArrayList<Inventory>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_INVENTORY_ITM_BY_TYPE));
			ps.setString(1, type);
			rs = ps.executeQuery();

			while (rs.next()) {

				Inventory inventory = new Inventory();
				inventory.setItemNo(rs.getString(1));
				inventory.setName(rs.getString(2));
				inventory.setDescription(rs.getString(3));
				inventory.setWarrentyYear(rs.getString(4));
				inventory.setAddedDate(rs.getString(5));
				inventory.setLocation(rs.getString(6));
				inventory.setStatus(rs.getString(7));
				inventory.setOwner(rs.getString(8));
				
				
				list.add(inventory);

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
	public void deleteAllItems(String type) {
		// TODO Auto-generated method stub
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_ALL_ITEMS));
			ps.setString(1, type);
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
	public void deleteItemById(String itemNo) {
		// TODO Auto-generated method stub
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_FROM_INVENTORY));

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
	public int getTotalDays(String itemNo) {
		// TODO Auto-generated method stub
		int totalDays = 0;
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			stmt = (CallableStatement) connection.prepareCall(" {call ToalDay(?,?)}");
			stmt.setString(1, itemNo);
			stmt.registerOutParameter(2, java.sql.Types.INTEGER);
			stmt.execute();
			totalDays = stmt.getInt(2);
			

		} catch (SQLException | ClassNotFoundException e) {
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
		
		return totalDays;
	}
	
	
	@Override
	public int getRemaingDays(String itemNo) {
		// TODO Auto-generated method stub
		int remainDays = 1;
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			stmt = (CallableStatement) connection.prepareCall("{call GetRemaingDays(?,?)}");
			stmt.setString(1, itemNo);
			stmt.registerOutParameter(2, java.sql.Types.INTEGER);
			stmt.execute();
			remainDays = stmt.getInt(2);
			

		} catch (SQLException | ClassNotFoundException e) {
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
		
		return remainDays;
	}
	
	
	@Override
	public void updateById(Inventory inventory) {
		// TODO Auto-generated method stub

				try {

					connection = DBConnectionUtil.getDBConnection();

					ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_INVENTORY_ITEM));
					connection.setAutoCommit(false);

					
					ps.setString(CommonConstants.COLUMN_INDEX_ONE, inventory.getName());
					ps.setString(CommonConstants.COLUMN_INDEX_TWO, inventory.getDescription());
					ps.setString(CommonConstants.COLUMN_INDEX_THREE, inventory.getWarrentyYear());
					ps.setString(CommonConstants.COLUMN_INDEX_FOUR, inventory.getAddedDate());
					ps.setString(CommonConstants.COLUMN_INDEX_FIVE, inventory.getLocation());
					ps.setString(CommonConstants.COLUMN_INDEX_SIX, inventory.getStatus());
					ps.setString(CommonConstants.COLUMN_INDEX_SEVEN, inventory.getOwner());
					ps.setString(CommonConstants.COLUMN_INDEX_EIGHT, inventory.getItemNo());
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
	public String addPurchaseOrderHead(PurchaseOrderHead head) {
		// TODO Auto-generated method stub
		
		String poID = CommonFunctions.generateIDs(getPurchaseOrderId(), CommonConstants.PURCHASE_ORDER_PREFIX);
		
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_PURCHASE_ORDER_TABLE));
			connection.setAutoCommit(false);

			head.setPoId(poID);
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, head.getPoId());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, head.getDate());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, head.getDescription());
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
		
		return poID;
		
	}
	
	
	
	
	

	
	private ArrayList<String> getPurchaseOrderId() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PURCHASE_ORDER_TABLE_ENTRY_COUNT));
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

	@Override
	public ArrayList<PurchaseOrderDetails> getPurchaseOrderDetails(String poID) {
		// TODO Auto-generated method stub
		ArrayList<PurchaseOrderDetails> list = new ArrayList<PurchaseOrderDetails>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PURCHASER_ORDER_DETAILS_BY_ID));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, poID);
			rs = ps.executeQuery();

			while (rs.next()) {

				PurchaseOrderDetails orderDetails = new PurchaseOrderDetails();
				orderDetails.setPoDeId(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				orderDetails.setPoId(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				orderDetails.setItemName(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				orderDetails.setQty(Integer.parseInt(rs.getString(CommonConstants.COLUMN_INDEX_FOUR)));
				orderDetails.setRequestedPrice(Float.parseFloat(rs.getString(CommonConstants.COLUMN_INDEX_FIVE)));
				
				
				
				list.add(orderDetails);

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
	public void addPurchaseOrderDetails(PurchaseOrderDetails details) {
		// TODO Auto-generated method stub
		String poDetailsID = CommonFunctions.generateIDs(getPurchaseOrderDetailsID(), CommonConstants.PURCHASE_ORDER_DETAILS_PREFIX);

		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_PURCHASE_ORDER_DETAILS));
			connection.setAutoCommit(false);

			details.setPoDeId(poDetailsID);
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, details.getPoDeId());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, details.getPoId());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, details.getItemName());
			ps.setInt(CommonConstants.COLUMN_INDEX_FOUR, details.getQty());
			ps.setFloat(CommonConstants.COLUMN_INDEX_FIVE, details.getRequestedPrice());
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
	
	private ArrayList<String> getPurchaseOrderDetailsID() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PURCHASE_ORDER_DETAILS_TABLE_ENTRY_COUNT));
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
	
	public PurchaseOrderHead getPoHeadDetailsList(String poID) {

		PurchaseOrderHead head =  new PurchaseOrderHead();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PURCHASE_ORDER_HEAD));
			ps.setString(1, poID);
			rs = ps.executeQuery();

			
			while (rs.next()) {
				
				head.setPoId(rs.getString(1));
				head.setDate(rs.getString(2));
				head.setStatus(rs.getString(3));
				head.setDescription(rs.getString(4));
				
				
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
		return head;

	}

	@Override
	public void deletePurchaseOrderDetailsById(String poDeID) {
		// TODO Auto-generated method stub
		
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_PURCHASE_ORDER_DETAILS_BY_ID));
			ps.setString(1, poDeID);
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
	
	
	
	public void updatePurchaseOrderDetailsById(PurchaseOrderDetails details) {
		// TODO Auto-generated method stub

				try {

					connection = DBConnectionUtil.getDBConnection();

					ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_EDIT_PURCHASE_ORDER_DETAILS_BY_ID));
					connection.setAutoCommit(false);

					
					ps.setString(CommonConstants.COLUMN_INDEX_ONE, details.getItemName());
					ps.setInt(CommonConstants.COLUMN_INDEX_TWO, details.getQty());
					ps.setDouble(CommonConstants.COLUMN_INDEX_THREE, details.getRequestedPrice());
					ps.setString(CommonConstants.COLUMN_INDEX_FOUR, details.getPoDeId());
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
	public ArrayList<PurchaseOrderHead> getAllPurchaseOrder() {
		// TODO Auto-generated method stub
		ArrayList<PurchaseOrderHead> list = new ArrayList<PurchaseOrderHead>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PURCHASE_ORDER_TABLE_ENTRY_COUNT));
			rs = ps.executeQuery();

			while (rs.next()) {

				PurchaseOrderHead head = new PurchaseOrderHead();
				head.setPoId(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				head.setDate(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				head.setStatus(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				head.setDescription(rs.getString(CommonConstants.COLUMN_INDEX_FOUR));
				
				
				
				list.add(head);

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
	public void deletePurchaseOrderDetailsByPOID(String poID) {
		// TODO Auto-generated method stub
		
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_EDIT_PURCHASE_ORDER_DETAILS_BY_PO_ID));
			ps.setString(1, poID);
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
	public void deletePurchaseOrder(String poID) {
		// TODO Auto-generated method stub
		
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_EDIT_PURCHASE_ORDER));
			ps.setString(1, poID);
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
	public Inventory getInventoryItemById(String inventoryID) {
		// TODO Auto-generated method stub
		Inventory inventory =  new Inventory();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_INVENTORY_ITEM_bY_ID));
			ps.setString(1, inventoryID);
			rs = ps.executeQuery();

			while (rs.next()) {

				inventory.setItemNo(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				inventory.setName(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				inventory.setDescription(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				inventory.setWarrentyYear(rs.getString(CommonConstants.COLUMN_INDEX_FOUR));
				inventory.setAddedDate(rs.getString(CommonConstants.COLUMN_INDEX_FIVE));
				inventory.setLocation(rs.getString(CommonConstants.COLUMN_INDEX_SIX));
				inventory.setStatus(rs.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				inventory.setOwner(rs.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				inventory.setType(rs.getString(CommonConstants.COLUMN_INDEX_NINE));
				
				
				

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
		return inventory;
	}

	@Override
	public String addQuotation(Quotation quotation) {
		// TODO Auto-generated method stub
		String quotationID = CommonFunctions.generateIDs(getQuoatationTableID(), CommonConstants.QUOTATION_PREFIX);
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_QUOTATION_TABLE));
			connection.setAutoCommit(false);

			quotation.setQuotationID(quotationID);
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, quotation.getQuotationID());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, quotation.getPoId());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, quotation.getSupplierName());
			ps.setString(CommonConstants.COLUMN_INDEX_FOUR, quotation.getContact());
			ps.setString(CommonConstants.COLUMN_INDEX_FIVE, quotation.getEmail());
			ps.setString(CommonConstants.COLUMN_INDEX_SIX, quotation.getAddLine1());
			ps.setString(CommonConstants.COLUMN_INDEX_SEVEN, quotation.getAddLine2());
			ps.setFloat(CommonConstants.COLUMN_INDEX_EIGHT, quotation.getDiscount());
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
		return quotationID;
	}
	
	
	
	
	private ArrayList<String> getQuoatationTableID() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_QUOTATION_TABLE_ENTRY_COUNT));
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
	
	@Override
	public void addQuotationDetails(QuotationDetails details) {
		// TODO Auto-generated method stub
		String quotationDetailsID = CommonFunctions.generateIDs(getQuoatationDetailsTableID(), CommonConstants.QUOTATION_DETAILS_PREFIX);
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_QUOTATION_DETAILS_TABLE));
			connection.setAutoCommit(false);

			details.setQuotationDeatailsID(quotationDetailsID);
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, details.getQuotationDeatailsID());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, details.getQuotationID());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, details.getPurchaseOrderDeID());
			ps.setFloat(CommonConstants.COLUMN_INDEX_FOUR, details.getPrice());
			ps.setString(CommonConstants.COLUMN_INDEX_FIVE, details.getDes());
			
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
	
	
	
	
	private ArrayList<String> getQuoatationDetailsTableID() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_QUOTATION_DETAILS_TABLE_ENTRY_COUNT));
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
	
	public ArrayList<Quotation> getQuoationList(String qoID) {

		ArrayList<Quotation> list = new ArrayList<Quotation>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_QUOTATION_BY_PO_ID));
			ps.setString(1, qoID);
			rs = ps.executeQuery();

			while (rs.next()) {

				Quotation quotation = new Quotation();
				quotation.setQuotationID(rs.getString(1));
				quotation.setPoId(rs.getString(2));
				quotation.setSupplierName(rs.getString(3));
				quotation.setContact(rs.getString(4));
				quotation.setEmail(rs.getString(5));
				quotation.setAddLine1(rs.getString(6));
				quotation.setAddLine2(rs.getString(7));
				quotation.setDiscount(Float.parseFloat(rs.getString(8)));
				
				
				list.add(quotation);

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
	
	public Quotation getQuoationByID(String qoID) {

		Quotation quotation = new Quotation();
		
		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_QUOTATION_BY_QUOATATION_ID));
			ps.setString(1, qoID);
			rs = ps.executeQuery();

			while (rs.next()) {

				
				quotation.setQuotationID(rs.getString(1));
				quotation.setPoId(rs.getString(2));
				quotation.setSupplierName(rs.getString(3));
				quotation.setContact(rs.getString(4));
				quotation.setEmail(rs.getString(5));
				quotation.setAddLine1(rs.getString(6));
				quotation.setAddLine2(rs.getString(7));
				quotation.setDiscount(Float.parseFloat(rs.getString(8)));
				
				
				

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
		return quotation;

	}
	
	

	@Override
	public ArrayList<QuotationDetails> getQuotationDetailsById(String qoID) {
		// TODO Auto-generated method stub
		ArrayList<QuotationDetails> quotationDetails =  new ArrayList<QuotationDetails>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_QUOTATION_BY_QO_ID));
			ps.setString(1, qoID);
			rs = ps.executeQuery();

			while (rs.next()) {
				QuotationDetails details= new QuotationDetails();
				details.setPurchaseOrderDeID(rs.getString(1));
				details.setPoId(rs.getString(2));
				details.setItemName(rs.getString(3));
				details.setQty(Integer.parseInt(rs.getString(4)));
				details.setRequestedPrice(Float.parseFloat(rs.getString(5)));
				details.setQuotationDeatailsID(rs.getString(6));
				details.setQuotationID(rs.getString(7));
				details.setPrice(Float.parseFloat(rs.getString(9)));
				details.setDes(rs.getString(10));
				
				quotationDetails.add(details);

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
		return quotationDetails;
	}





	@Override
	public void deleteALLPO() {
		// TODO Auto-generated method stub
		try {

			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_ALL_PO1));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_ALL_PO2));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_ALL_PO3));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_ALL_PO4));

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
	public void deleteQuoatationByID(String qoID) {
		// TODO Auto-generated method stub
		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_QUOTATION_DETAIS_BY_ID));
			ps.setString(1, qoID);
			ps.execute();
			
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_QUOTATION_BY_ID));
			ps.setString(1, qoID);
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
	public void updatePurchaseOrderStatus(String status, String poID) {
		// TODO Auto-generated method stub
		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_PURCHASE_ORDER_STATUS));
			ps.setString(1, status);
			ps.setString(2, poID);
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
	public int getQuatationCountForPo(String poID) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			connection = DBConnectionUtil.getDBConnection();

			
			
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_QUOTATION_COUNT_FOR_PO));
			ps.setString(1, poID);
			rs = ps.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
				

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
		return count;
		
	}

	@Override
	public void updateQuotationStatus(String status, String qoID) {

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_QUOTATION_STATUS));
			ps.setString(1, status);
			ps.setString(2, qoID);
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
	
	
	public ArrayList<Quotation> getQuotationByIdAndStatus(String Status, String poID) {
		// TODO Auto-generated method stub
		ArrayList<Quotation> quotationDetails =  new ArrayList<Quotation>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_QUOTATION_BY_ID_AND_STATUS));
			ps.setString(1, Status);
			ps.setString(2, poID);
			rs = ps.executeQuery();

			while (rs.next()) {

				Quotation quotation = new Quotation();
				quotation.setQuotationID(rs.getString(1));
				quotation.setPoId(rs.getString(2));
				quotation.setSupplierName(rs.getString(3));
				quotation.setContact(rs.getString(4));
				quotation.setEmail(rs.getString(5));
				quotation.setAddLine1(rs.getString(6));
				quotation.setAddLine2(rs.getString(7));
				quotation.setDiscount(Float.parseFloat(rs.getString(8)));
				
				
				quotationDetails.add(quotation);

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
		return quotationDetails;
	}

	@Override
	public void addIMNotification(InventoryNotifications notifications) {

		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_IM_NOTIFICATIONS));
			connection.setAutoCommit(false);

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, notifications.getDescription());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, notifications.getOwner());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, notifications.getDataID());
			ps.setInt(CommonConstants.COLUMN_INDEX_FOUR, notifications.getRemaining());
			ps.setString(CommonConstants.COLUMN_INDEX_FIVE, notifications.getType());
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
	public ArrayList<InventoryNotifications> getAllNotifications(String owner) {
		// TODO Auto-generated method stub
		ArrayList<InventoryNotifications> list =  new ArrayList<InventoryNotifications>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SELECT_ALL_FROM_NOTIFICATION_BY_OWNER));
			ps.setString(1, owner);
			rs = ps.executeQuery();

			while (rs.next()) {
				InventoryNotifications notifications = new InventoryNotifications();
				notifications.setId(Integer.parseInt(rs.getString(1)));
				notifications.setDescription(rs.getString(2));
				notifications.setSeenState(rs.getString(3));
				notifications.setOwner(rs.getString(4));
				notifications.setDataID(rs.getString(5));
				notifications.setRemaining(Integer.parseInt(rs.getString(6)));
				notifications.setDate(rs.getString(7));
				notifications.setType(rs.getString(8));
				
				
				
				list.add(notifications);

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
	public int getImNotificationCount(String owner) {
		int count = 0;
		try {
			connection = DBConnectionUtil.getDBConnection();

			
			
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_IM_NOTIFICATION_COUNT));
			ps.setString(1, owner);
			rs = ps.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
				

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
		return count;
	}
	
	
	@Override
	public void updateIMNotificationStatus(String id) {

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_IM_NOTIFICATION_STATUS));
			ps.setString(1, id);
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

	
}
