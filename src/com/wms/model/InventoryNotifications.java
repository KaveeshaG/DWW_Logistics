package com.wms.model;

public class InventoryNotifications {

	private int id;
	private String description;
	private String seenState;
	private String owner;
	private String dataID;
	private String date;
	private String type;
	private int remaining;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSeenState() {
		return seenState;
	}

	public void setSeenState(String seenState) {
		this.seenState = seenState;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDataID() {
		return dataID;
	}

	public void setDataID(String dataID) {
		this.dataID = dataID;
	}

	
	public int getRemaining() {
		return remaining;
	}

	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}
	
	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "InventoryNotifications [id=" + id + ", description=" + description + ", seenState=" + seenState
				+ ", owner=" + owner + ", dataID=" + dataID + ", date=" + date + ", type=" + type + ", remaining="
				+ remaining + "]";
	}

	

}
