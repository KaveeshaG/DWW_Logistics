package com.wms.model;

public class PurchaseOrderHead extends PurchaceOrder {
	private String date;
	private String description;
	private String status;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PurchaseOrderHead [date=" + date + ", description=" + description + ", status=" + status + ", poId="
				+ poId + "]";
	}

	
}
