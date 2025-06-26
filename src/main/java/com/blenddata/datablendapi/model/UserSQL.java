package com.blenddata.datablendapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserSQL {
    @Id
    private String userId;
    private String phone;
    private String address;

    public String getUserId() { return userId; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    public void setUserId(String userId) { this.userId = userId; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
}
