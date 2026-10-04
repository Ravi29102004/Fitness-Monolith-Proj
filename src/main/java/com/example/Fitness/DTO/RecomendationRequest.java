package com.example.Fitness.DTO;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecomendationRequest {

    private String userId;
    private String activityId;

    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;


   private String type;

    public List<String> recommendation;

}
