package com.wms.model;

public class PackageDetails {
	private String packgDetId;
	private String packgId;
	private String productId;
	private String serviceId;
	private boolean product;
	private boolean service;
	public String getPackgDetId() {
		return packgDetId;
	}
	public void setPackgDetId(String packgDetId) {
		this.packgDetId = packgDetId;
	}
	public String getPackgId() {
		return packgId;
	}
	public void setPackgId(String packgId) {
		this.packgId = packgId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public boolean isProduct() {
		return product;
	}
	public void setProduct(boolean product) {
		this.product = product;
	}
	public boolean isService() {
		return service;
	}
	public void setService(boolean service) {
		this.service = service;
	}
	@Override
	public String toString() {
		return "PackageDetails [packgDetId=" + packgDetId + ", packgId=" + packgId + ", productId=" + productId
				+ ", serviceId=" + serviceId + ", product=" + product + ", service=" + service + "]";
	}
	
	
	
	

}
