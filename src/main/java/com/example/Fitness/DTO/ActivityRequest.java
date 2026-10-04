package com.example.Fitness.DTO;

import com.example.Fitness.model.ActivityType;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

public class ActivityRequest {


    @Getter
    private String userId;

    @Getter
    private ActivityType type;


    @Getter
    private Map<String,Object> additionalMatrix;



    @Getter
    private Integer duration;
    @Getter
    private Integer caloriesBurned;
    @Getter
    private LocalDateTime startTime;




//    public ActivityType getType() {
//        return
//    }
}
