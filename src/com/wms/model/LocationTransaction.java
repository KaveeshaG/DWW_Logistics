package com.wms.model;

public class LocationTransaction {


			private String id;
			private String currentLoc;
			private String customerId;
			private String GRNNo;
			private String destiLoc;
			private String reason;
			private int status;
			
			
			
			public LocationTransaction(String id, String currentLoc, String customerId, String GRNNo, String destiLoc, String reason, int status) {
				super();
				this.id = id;
				this.currentLoc = currentLoc;
				this.customerId = customerId;
				this.GRNNo = GRNNo;
				this.destiLoc = destiLoc;
				this.reason = reason;
				this.status = status;
			}
			public LocationTransaction() {
			}
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
			public String getCurrentLoc() {
				return currentLoc;
			}
			public void setCurrentLoc(String currentLoc) {
				this.currentLoc = currentLoc;
			}
			
			
			public String getCustomerId() {
				return customerId;
			}
			public void setCustomerId(String customerId) {
				this.customerId = customerId;
			}
			public String getGRNNo() {
				return GRNNo;
			}
			public void setGRNNo(String gRNNo) {
				GRNNo = gRNNo;
			}
			public String getDestiLoc() {
				return destiLoc;
			}
			public void setDestiLoc(String destiLoc) {
				this.destiLoc = destiLoc;
			}
			public String getReason() {
				return reason;
			}
			public void setReason(String reason) {
				this.reason = reason;
			}
			public int getStatus() {
				return status;
			}
			public void setStatus(int status) {
				this.status = status;
			}
			@Override
			public String toString() {
				return "LocationTransaction [id=" + id + ", currentLoc=" + currentLoc + ", customerId=" + customerId
						+ ", GRNNo=" + GRNNo + ", destiLoc=" + destiLoc + ", reason=" + reason + ", status=" + status
						+ "]";
			}
		
			
			

	}

