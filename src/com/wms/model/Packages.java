package com.wms.model;

public class Packages {
	private String packgId;
	private String supplierId;
	private double totPrice;
	private double bonus;
	public String getPackgId() {
		return packgId;
	}
	public void setPackgId(String packgId) {
		this.packgId = packgId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public double getTotPrice() {
		return totPrice;
	}
	public void setTotPrice(double totPrice) {
		this.totPrice = totPrice;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "Packages [packgId=" + packgId + ", supplierId=" + supplierId + ", totPrice=" + totPrice + ", bonus="
				+ bonus + "]";
	}
	
	
	

}
