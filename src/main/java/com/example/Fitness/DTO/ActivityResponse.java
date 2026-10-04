package com.example.Fitness.DTO;

import com.example.Fitness.model.ActivityType;
import com.example.Fitness.model.Recommendations;
import com.example.Fitness.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponse {


    private String id;
    private String userId;

    private ActivityType type;


     private Map<String,Object> additionalMatrix;



    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;





}
