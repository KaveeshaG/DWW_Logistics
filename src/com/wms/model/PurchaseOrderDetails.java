package com.wms.model;

public class PurchaseOrderDetails extends PurchaceOrder {
	protected String poDeId;
	protected String itemName;
	protected int qty;
	protected float requestedPrice;

	public String getPoDeId() {
		return poDeId;
	}

	public void setPoDeId(String poDeId) {
		this.poDeId = poDeId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getRequestedPrice() {
		return requestedPrice;
	}

	public void setRequestedPrice(float requestedPrice) {
		this.requestedPrice = requestedPrice;
	}

	@Override
	public String toString() {
		return "PurchaseOrderDetails [poDeId=" + poDeId + ", itemName=" + itemName + ", qty=" + qty
				+ ", requestedPrice=" + requestedPrice + "]";
	}

}
