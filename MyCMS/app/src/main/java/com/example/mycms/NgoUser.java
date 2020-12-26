package com.example.mycms;

public class NgoUser {
     String address;
     String email;
      String name;
    String person;
      String phone;
    String reg;
    String status;
    String upi;

    public NgoUser() {
    }

    public NgoUser(String address, String email, String name, String person, String phone, String reg, String status, String upi) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.person = person;
        this.phone = phone;
        this.reg = reg;
        this.status = status;
        this.upi = upi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getUpi() {
        return upi;
    }

    public void setUpi(String upi) {
        this.upi = upi;
    }
}
