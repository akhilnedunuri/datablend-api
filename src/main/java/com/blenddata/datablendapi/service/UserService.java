package com.blenddata.datablendapi.service;

import com.blenddata.datablendapi.model.UserCSV;
import com.blenddata.datablendapi.model.UserSQL;
import com.blenddata.datablendapi.model.UserMongo;
import com.blenddata.datablendapi.model.UserCombined;
import com.blenddata.datablendapi.repository.UserMongoRepository;
import com.blenddata.datablendapi.repository.UserSQLRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserSQLRepository sqlRepository;

    @Autowired
    private UserMongoRepository mongoRepository;

    // ✅ Read from CSV file in src/main/resources/users.csv
    public List<UserCSV> readCSVFile() {
        try {
            return new CsvToBeanBuilder<UserCSV>(
                new InputStreamReader(new ClassPathResource("users.csv").getInputStream())
            ).withType(UserCSV.class).build().parse();
        } catch (Exception e) {
            throw new RuntimeException("CSV File reading failed", e);
        }
    }

    // ✅ Merge CSV, SQL, and Mongo data into one combined list
    public List<UserCombined> getAllCombinedUsers() {
        List<UserCSV> csvUsers = readCSVFile();

        // Load all MySQL users into map
        Map<String, UserSQL> sqlMap = new HashMap<>();
        for (UserSQL user : sqlRepository.findAll()) {
            sqlMap.put(user.getUserId(), user);
        }

        // Load all MongoDB users into map
        Map<String, UserMongo> mongoMap = new HashMap<>();
        for (UserMongo user : mongoRepository.findAll()) {
            mongoMap.put(user.getUserId(), user);
        }

        // Combine all data into UserCombined
        List<UserCombined> combinedList = new ArrayList<>();
        for (UserCSV csv : csvUsers) {
            UserCombined combined = new UserCombined();
            combined.setUserId(csv.getUserId());
            combined.setName(csv.getName());
            combined.setEmail(csv.getEmail());

            // From MySQL
            if (sqlMap.containsKey(csv.getUserId())) {
                UserSQL sql = sqlMap.get(csv.getUserId());
                combined.setPhone(sql.getPhone());
                combined.setAddress(sql.getAddress());
            }

            // From MongoDB
            if (mongoMap.containsKey(csv.getUserId())) {
                UserMongo mongo = mongoMap.get(csv.getUserId());
                combined.setOccupation(mongo.getOccupation());
                combined.setInterests(mongo.getInterests());
            }

            combinedList.add(combined);
        }

        return combinedList;
    }
}
