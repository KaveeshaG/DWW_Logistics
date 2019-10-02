package com.wms.model;


public class dataModel {
	private String cabType;
	private String date;
	private String tripFrom;
	private String tripTo;	
	private int jobId;	
	private String name;
	private String address;
	private String city;
	private int mobileNum;
	private String gender;
	private String email;
	private int driverID;
	private String vNum;
	private String vType;
	private String vModel;
	private String IRdate;
	private String TRDate;
	private int vid;
	private int deleteId;
	
	public void setDeleteId(int deleteID) {
		deleteId = deleteID;
	}
	
	
	public void setVid(int Vid) {
		vid = Vid;
	}
	public void setVehicleNum(String vnum) {
		vNum = vnum;
	}
	public void setVehicleType(String vtype) {
		vType = vtype;
	}
	public void setVehicleModel(String vmodel) {
		vModel = vmodel;
	}
	public void setRdate(String irdate) {
		IRdate = irdate;
	}
	public void setTRDate(String trdate) {
		TRDate = trdate;
	}


	public void setName(String Nname) {
		name = Nname;
	}	
	public void setDriverId(int did) {
		driverID = did;
	}
	public void setEmail(String NEmail) {
		email = NEmail;
	}
	public void setAddress(String address1, String address2) {
		address = address1 + address2;
	}
	public void setCity(String Ncity) {
		city = Ncity;
	}
	public void setGender(String Ngender) {
		gender = Ngender;
	}
	
	public void setMobileNum(int NMobileNum) {
		mobileNum = NMobileNum;
	}	
	
	public void setdate(String newDate) {
		date = newDate;
	}
	
	public void settripFrom(String newtripFrom) {
		tripFrom = newtripFrom;
	}
	
	public void settripTo(String newtripTo) {
		tripTo = newtripTo;
	}
	
	public void setJobId(int newJobId) {
		jobId = newJobId;
	}
	public void setCabtype(String newcabtyle) {
		cabType = newcabtyle;
	}
	
	
	public String getcabType() {
		return cabType;
	}
	
	public String getdate() {
		return date;
	}
	
	public String gettripFrom() {
		return tripFrom;
	}
	
	public String gettripTo() {
		return tripTo;
	}
	public int getDriverId() {
		return driverID;
	}
	
	public int getJobId() {		
		
		return jobId;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public String getGender() {
		return gender;
	}
	public String getCity() {
		return city;
	}
	public int getMobileNumber() {
		return mobileNum;
	}
	public String getVNum() {
		return vNum;
	}
	public String getVtype() {
		return vType;
	}
	public String getVmodel() {
		return vModel;
		
	}
	public String getIRDate() {
		return IRdate;
	}
	public String getTRDate() {
		return TRDate;
	}
	public int getVid() {
		return vid;
	}
	public int getDeleteId() {
		return deleteId;
	}
	


	
	
	
}
