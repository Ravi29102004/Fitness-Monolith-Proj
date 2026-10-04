package com.example.Fitness.Controller;


import com.example.Fitness.DTO.RecomendationRequest;
import com.example.Fitness.Service.RecomendationService;
import com.example.Fitness.model.Recommendations;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecomendationService recomendationService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendations> generateReommendation(@RequestBody RecomendationRequest request){
        Recommendations recommendations=recomendationService.generateRecomendation(request);

        return ResponseEntity.ok(recommendations);

    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendations>> getUserReommendation(@PathVariable String userId){
        List<Recommendations> recommendationsList=recomendationService.getUserRecomendation(userId);

        return ResponseEntity.ok(recommendationsList);

    }



    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendations>> getActivityReommendation(@PathVariable String activityId){
        List<Recommendations> recommendationsList=recomendationService.getActivityRecomendation(activityId);

        return ResponseEntity.ok(recommendationsList);

    }


}
