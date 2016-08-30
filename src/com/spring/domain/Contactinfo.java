package com.spring.domain;

public class Contactinfo {
    private Integer contactid;

    private Integer userid;

    private String street1;

    private String street2;

    private String city;

    private String province;

    private String country;

    private String zip;

    @Override
	public String toString() {
		return "Contactinfo [contactid=" + contactid + ", userid=" + userid + ", street1=" + street1 + ", street2="
				+ street2 + ", city=" + city + ", province=" + province + ", country=" + country + ", zip=" + zip
				+ ", email=" + email + ", homephone=" + homephone + ", cellphone=" + cellphone + ", officephone="
				+ officephone + "]";
	}

	private String email;

    private String homephone;

    private String cellphone;

    private String officephone;

    public Integer getContactid() {
        return contactid;
    }

    public void setContactid(Integer contactid) {
        this.contactid = contactid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1 == null ? null : street1.trim();
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2 == null ? null : street2.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHomephone() {
        return homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone == null ? null : homephone.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getOfficephone() {
        return officephone;
    }

    public void setOfficephone(String officephone) {
        this.officephone = officephone == null ? null : officephone.trim();
    }
}