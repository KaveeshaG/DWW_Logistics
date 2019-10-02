package com.wms.model;

public class SupplierServicesModal {
	private String serviceId;
	private String supplierId;
	private String serviceName;
	private int serviceHrs;
	private double serPrice;
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public int getServiceHrs() {
		return serviceHrs;
	}
	public void setServiceHrs(int serviceHrs) {
		this.serviceHrs = serviceHrs;
	}
	public double getSerPrice() {
		return serPrice;
	}
	public void setSerPrice(double serPrice) {
		this.serPrice = serPrice;
	}
	@Override
	public String toString() {
		return "SupplierService [serviceId=" + serviceId + ", supplierId=" + supplierId + ", serviceName=" + serviceName
				+ ", serviceHrs=" + serviceHrs + ", serPrice=" + serPrice + "]";
	}
	
	
	
	
	

	
	
	
	

}
