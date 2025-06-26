package com.blenddata.datablendapi.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "usermongo")
public class UserMongo {
    @Id
    private String userId;
    private String occupation;
    private String interests;

    public String getUserId() { return userId; }
    public String getOccupation() { return occupation; }
    public String getInterests() { return interests; }

    public void setUserId(String userId) { this.userId = userId; }
    public void setOccupation(String occupation) { this.occupation = occupation; }
    public void setInterests(String interests) { this.interests = interests; }
}
