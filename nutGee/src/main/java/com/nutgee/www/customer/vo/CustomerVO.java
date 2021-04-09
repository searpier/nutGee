package com.nutgee.www.customer.vo;

public class CustomerVO {

	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String birthYear;
	private String birthDate;
	private String indate;
	private String updateDate;
	private String gender;
	private String userType;
	private Long nutAmount;
	private String status;

	public CustomerVO(String id, String pwd, String name, String phone, String birthYear, String birthDate,
			String indate, String updateDate, String gender, String userType, Long nutAmount, String status) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.birthYear = birthYear;
		this.birthDate = birthDate;
		this.indate = indate;
		this.updateDate = updateDate;
		this.gender = gender;
		this.userType = userType;
		this.nutAmount = nutAmount;
		this.status = status;
	}

	public CustomerVO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Long getNutAmount() {
		return nutAmount;
	}

	public void setNutAmount(Long nutAmount) {
		this.nutAmount = nutAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + ", birthYear="
				+ birthYear + ", birthDate=" + birthDate + ", indate=" + indate + ", updateDate=" + updateDate
				+ ", gender=" + gender + ", userType=" + userType + ", nutAmount=" + nutAmount + ", status=" + status
				+ "]";
	}

}
