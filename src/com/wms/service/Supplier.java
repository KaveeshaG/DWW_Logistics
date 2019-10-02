package com.wms.service;


import java.util.ArrayList;

import com.wms.model.SupplierAcount;
import com.wms.model.SupplierProduct;

public interface Supplier {

	
	/**
	 * Add Items
	 * @param inventory
	 */
	public void addProduct(SupplierProduct product);
	
	public void deleteAllProductBySupID(String supID);
	
	public ArrayList<SupplierProduct> getProductTableList(String supID);
	
	public void deleteProductById(String productID);
	
	public void addSuppliers(SupplierAcount supplier);
	
	public ArrayList<SupplierAcount> getSupplierTableList();
	
	public void deleteSupplier();
	
	public void deleteSupplierAccounttById(String supplierID);
	
	public void updateSupplierAccountByID(SupplierAcount acount);
	
	public SupplierAcount getSupplierDetailsByID(String supplierID);

	public SupplierProduct getProductByID(String productID);

	public void updateProductByID(String productID, SupplierProduct product);
	
	public ArrayList<SupplierProduct> getAllSuppliersproduct();
	
	
	
	
}
