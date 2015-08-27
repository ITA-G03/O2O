package ita.o2o.vo;

import ita.o2o.entity.base.Business;

public class BusinessVo {
	private int businessId;
	private String realName;
	private int idCardId;
	private int licenseId;
	private int statusId;
	private String statusName;
	
	
	public BusinessVo(Business business){
		this.businessId=business.getBusinessId();
		this.realName=business.getRealName();
		this.idCardId=business.getIdCardId();
		this.licenseId=business.getLicenseId();
		//this.statusId=business.getStatus().getStatusId();
		this.statusName=business.getStatus().getStatusName();
		
	}
	
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public int getIdCardId() {
		return idCardId;
	}
	public void setIdCardId(int idCardId) {
		this.idCardId = idCardId;
	}
	public int getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(int licenseId) {
		this.licenseId = licenseId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public BusinessVo() {
		super();
	}
	
	
}
