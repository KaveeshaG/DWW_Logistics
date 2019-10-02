package com.wms.service;

import java.util.ArrayList;

import com.wms.model.Inventory;
import com.wms.model.InventoryNotifications;
import com.wms.model.PurchaseOrderDetails;
import com.wms.model.PurchaseOrderHead;
import com.wms.model.Quotation;
import com.wms.model.QuotationDetails;

public interface IInventoryManager {

	/**
	 * Add Items
	 * 
	 * @param inventory
	 */
	public void addItems(Inventory inventory);

	/**
	 * get all in Inventory table
	 */
	public ArrayList<Inventory> getInventoryList(String type);

	/**
	 * delete all Inventory Items
	 */
	public void deleteAllItems(String type);

	/**
	 * Add assignments
	 * 
	 * @param inventory
	 */
	public void deleteItemById(String itemNo);

	/**
	 * Get total days of inventory item
	 * 
	 * @param itemNo
	 */
	public int getTotalDays(String itemNo);

	/**
	 * Get reaming days of inventory item
	 * 
	 * @param itemNo
	 */
	public int getRemaingDays(String itemNo);

	/**
	 * Update details of inventory item
	 * 
	 * @param inventory
	 */
	public void updateById(Inventory inventory);

	/**
	 * Update details of inventory item
	 * 
	 * @param head
	 */
	public String addPurchaseOrderHead(PurchaseOrderHead head);

	/**
	 * select all from Purchase Order details
	 * 
	 * @param poID
	 */
	public ArrayList<PurchaseOrderDetails> getPurchaseOrderDetails(String poID);

	/**
	 * insert into PurchaseOrder Details
	 * 
	 * @param details
	 */
	public void addPurchaseOrderDetails(PurchaseOrderDetails details);

	/**
	 * get purchase order head details
	 * 
	 * @param poID
	 */
	public PurchaseOrderHead getPoHeadDetailsList(String poID);

	/**
	 * delete purchase order details by id
	 * 
	 * @param poDeID
	 */
	public void deletePurchaseOrderDetailsById(String poDeID);

	/**
	 * edit purchase order details by id
	 * 
	 * @param details
	 */
	public void updatePurchaseOrderDetailsById(PurchaseOrderDetails details);

	/**
	 * get all purchase orders
	 */
	public ArrayList<PurchaseOrderHead> getAllPurchaseOrder();

	/**
	 * delete purchase order details by id
	 * 
	 * @param poID
	 */
	public void deletePurchaseOrderDetailsByPOID(String poID);
	
	/**
	 * delete purchase order
	 * 
	 * @param poID
	 */
	public void deletePurchaseOrder(String poID);
	
	/**
	 * get Inventory Item By ID
	 * @param inventoryID
	 */
	public Inventory getInventoryItemById(String inventoryID);
	
	/**
	 * Add Quotation 
	 * @param quotation
	 */
	public String addQuotation(Quotation quotation);
	
	/**
	 * Add Quotation Details
	 * @param details
	 */
	public void addQuotationDetails(QuotationDetails details);
	
	/**
	 * Get quotation list
	 * @param qoID
	 */
	public ArrayList<Quotation> getQuoationList(String qoID);
	
	
	
	/**
	 * Get quotation details
	 * @param qoID
	 */
	public ArrayList<QuotationDetails> getQuotationDetailsById(String qoID);
	
	
	/**
	 * Get quotation by quotation ID
	 * 
	 */
	public Quotation getQuoationByID(String qoID);
	
	/**
	 * delete all PO
	 */
	public void deleteALLPO();
	
	/**
	 * delete Quotation By Id
	 * @param qoID
	 */
	public void deleteQuoatationByID(String qoID);
	
	
	
	/**
	 * delete ALL Quotation By POID
	 * @param poID
	 */
	public void updatePurchaseOrderStatus(String status, String poID);
	
	
	/**
	 * get count of Quotations of POID
	 * @param poID
	 */
	public int getQuatationCountForPo(String poID);
	
	/**
	 * update state of qutation
	 * @param status
	 */
	public void updateQuotationStatus(String status, String qoID);
	
	
	public ArrayList<Quotation> getQuotationByIdAndStatus(String Status, String poID);
	
	public void addIMNotification(InventoryNotifications notifications);
	
	public ArrayList<InventoryNotifications> getAllNotifications(String owner);
	
	public int getImNotificationCount(String owner);
	
	public void updateIMNotificationStatus(String id);
	
}
