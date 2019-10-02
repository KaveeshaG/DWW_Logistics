package com.wms.model;

public class Quotation extends PurchaseOrderDetails {
	protected String quotationID;
	protected String poId;
	protected String supplierName;
	protected String contact;
	protected String email;
	protected String addLine1;
	protected String addLine2;
	protected float discount;
	protected float total;

	public String getQuotationID() {
		return quotationID;
	}

	public void setQuotationID(String quotationID) {
		this.quotationID = quotationID;
	}

	public String getPoId() {
		return poId;
	}

	public void setPoId(String poId) {
		this.poId = poId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddLine1() {
		return addLine1;
	}

	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}

	public String getAddLine2() {
		return addLine2;
	}

	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Quotation [quotationID=" + quotationID + ", poId=" + poId + ", supplierName=" + supplierName
				+ ", contact=" + contact + ", email=" + email + ", addLine1=" + addLine1 + ", addLine2=" + addLine2
				+ ", discount=" + discount + ", total=" + total + "]";
	}

	

}
