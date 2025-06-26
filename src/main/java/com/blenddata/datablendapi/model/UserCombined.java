package com.blenddata.datablendapi.model;

public class UserCombined {
    private String userId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String occupation;
    private String interests;

    // Constructors
    public UserCombined() {}

    public UserCombined(String userId, String name, String email, String phone, String address, String occupation, String interests) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.occupation = occupation;
        this.interests = interests;
    }

    // Getters
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getOccupation() { return occupation; }
    public String getInterests() { return interests; }

    // Setters
    public void setUserId(String userId) { this.userId = userId; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
    public void setOccupation(String occupation) { this.occupation = occupation; }
    public void setInterests(String interests) { this.interests = interests; }
}
