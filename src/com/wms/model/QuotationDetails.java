package com.wms.model;

public class QuotationDetails extends Quotation{
	private String quotationDeatailsID;
	private String purchaseOrderDeID;
	private float price;
	private String des;
	public String getQuotationDeatailsID() {
		return quotationDeatailsID;
	}
	public void setQuotationDeatailsID(String quotationDeatailsID) {
		this.quotationDeatailsID = quotationDeatailsID;
	}
	public String getPurchaseOrderDeID() {
		return purchaseOrderDeID;
	}
	public void setPurchaseOrderDeID(String purchaseOrderDeID) {
		this.purchaseOrderDeID = purchaseOrderDeID;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	@Override
	public String toString() {
		return "QuotationDetails [quotationDeatailsID=" + quotationDeatailsID + ", purchaseOrderDeID="
				+ purchaseOrderDeID + ", price=" + price + ", des=" + des + ", quotationID=" + quotationID + ", poId="
				+ poId + ", supplierName=" + supplierName + ", contact=" + contact + ", email=" + email + ", addLine1="
				+ addLine1 + ", addLine2=" + addLine2 + ", discount=" + discount + ", total=" + total + "]";
	}
	
	
	
}
