package com.example.Fitness.Service;


import com.example.Fitness.DTO.RecomendationRequest;
import com.example.Fitness.Repository.ActivityRepository;
import com.example.Fitness.Repository.RecomendationRepository;
import com.example.Fitness.Repository.UserRepository;
import com.example.Fitness.model.Activity;
import com.example.Fitness.model.Recommendations;
import com.example.Fitness.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecomendationService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecomendationRepository recomendationRepository;



    public Recommendations generateRecomendation(RecomendationRequest request) {
        User user=userRepository.findById(request.getUserId())
                .orElseThrow(()->new RuntimeException("User Not Found : "+request.getUserId()));

        Activity activity=activityRepository.findById(request.getActivityId())
                .orElseThrow(()->new RuntimeException("Activity Not Found : "+ request.getActivityId()));



        Recommendations recommendations=Recommendations.builder()
               .user(user)
                .activity(activity)
                .type(String.valueOf(activity.getType()))
                .reommendation(activity.getRecommendations().toString())
                .improvements(request.getImprovements())
               .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();


        Recommendations savedRecommendation=recomendationRepository.save(recommendations);
        return savedRecommendation;




    }




//    public Recommendations generateRecomendation(RecomendationRequest request) {
//
//        Authentication authentication =
//                SecurityContextHolder.getContext().getAuthentication();
//
//        String userId = authentication.getName();
//
//        User user = userRepository.findById(userId)
//                .orElseThrow(() ->
//                        new RuntimeException("User Not Found : " + userId));
//
//        Activity activity = activityRepository.findById(request.getActivityId())
//                .orElseThrow(() ->
//                        new RuntimeException(
//                                "Activity Not Found : " + request.getActivityId()));
//
//        Recommendations recommendations = Recommendations.builder()
//                .user(user)
//                .activity(activity)
//                .improvements(request.getImprovements())
//                .suggestions(request.getSuggestions())
//                .safety(request.getSafety())
//                .build();
//
//        Recommendations savedRecommendation =
//                recomendationRepository.save(recommendations);
//
//        return savedRecommendation;
//    }
//
//







    public List<Recommendations> getUserRecomendation(String userId) {
        return recomendationRepository.findByUserId(userId);
    }

    public List<Recommendations> getActivityRecomendation(String activityId) {
        return recomendationRepository.findByActivityId(activityId);
    }
}
