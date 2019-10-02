package com.wms.model;

public class Inventory {
	private String itemNo;
	private String name;
	private String description;
	private String warrentyYear;
	private String addedDate;
	private String owner;
	private String location;
	private String status;
	private String type;

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWarrentyYear() {
		return warrentyYear;
	}

	public void setWarrentyYear(String warrentyYear) {
		this.warrentyYear = warrentyYear;
	}

	public String getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Inventory [itemNo=" + itemNo + ", name=" + name + ", description=" + description + ", warrentyYear="
				+ warrentyYear + ", addedDate=" + addedDate + ", owner=" + owner + ", location=" + location
				+ ", status=" + status + ", type=" + type + "]";
	}
	
	

	
	

}
