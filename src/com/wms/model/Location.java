package com.wms.model;

public class Location {

		
		private String id;
		private float capacity;
		private float available;
		
		
		public Location(String id, float capacity, float available) {
			super();
			this.id = id;
			this.capacity = capacity;
			this.available = available;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public float getCapacity() {
			return capacity;
		}
		public void setCapacity(float capacity) {
			this.capacity = capacity;
		}
		public float getAvailable() {
			return available;
		}
		public void setAvailable(float available) {
			this.available = available;
		}
		@Override
		public String toString() {
			return "Location [id=" + id + ", capacity=" + capacity + ", available=" + available + "]";
		}

	}


