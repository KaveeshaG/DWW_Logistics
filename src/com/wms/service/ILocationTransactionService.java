package com.wms.service;

import java.util.ArrayList;

import com.wms.model.*;

public interface ILocationTransactionService {

	
	public void locationTransaction(LocationTransaction lt);
	
	public LocationTransaction getLocationTransactionId(String id);
	
	public ArrayList<LocationTransaction> getLocationTransaction();
	
	public LocationTransaction updateLocationTransactionReq(String ID, LocationTransaction lt);
	
	public void removeLocationTransactionReq(String ID);

	public void adminConfirmTransaction(LocationTransaction lt);

	public void adminDeleteTransaction(LocationTransaction lt);
}
