package com.dolphinevents.companyservice.dto;

public class CompanyDto {
    
    public CompanyDto() {

    }

    private Integer id;
    private String address;
    private String email;
    private String password;
    private String phone;

    

    public CompanyDto(Integer id, String address, String email, String password, String phone) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    

}
