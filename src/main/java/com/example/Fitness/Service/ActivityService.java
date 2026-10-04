package com.example.Fitness.Service;


import com.example.Fitness.DTO.ActivityRequest;
import com.example.Fitness.DTO.ActivityResponse;
import com.example.Fitness.Repository.ActivityRepository;
import com.example.Fitness.Repository.UserRepository;
import com.example.Fitness.model.Activity;
import com.example.Fitness.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//import static sun.security.krb5.Config.duration;

@Service
@RequiredArgsConstructor

public class ActivityService {
    private final ActivityRepository activityRepository;

    private final UserRepository userRepository;



//    public ActivityResponse trackActivity(ActivityRequest request) {
//        User user=userRepository.findById(request.getUserId())
//                .orElseThrow(()->new RuntimeException("Invalid User: "+request.getUserId()));
//          Activity activity= Activity.builder()
//                  .user(user)
//                  .type(request.getType())
//                  .duration(request.getDuration())
//                  .caloriesBurned(request.getCaloriesBurned())
//                  .startTime(request.getStartTime())
//                  .additionalMatrix(request.getAdditionalMatrix())
//                  .build();
//
//          //mapping isliye kar rahe hai ki request se response karwana hai
//       Activity savedActivity= activityRepository.save(activity);
//
//       return mapToResponse(savedActivity);
//    }





//    public ActivityResponse trackActivity(ActivityRequest request) {
//
//        User user = userRepository.findById(request.getUserId())
//                .orElseThrow(() ->
//                        new RuntimeException("Invalid User: " + request.getUserId()));
//
//        Activity activity = Activity.builder()
//                .user(user)
//                .type(request.getType())
//                .duration(request.getDuration())
//                .caloriesBurned(request.getCaloriesBurned())
//                .startTime(request.getStartTime())
//                .additionalMatrix(request.getAdditionalMatrix())
//                .build();
//
//        Activity savedActivity = activityRepository.save(activity);
//
//        return mapToResponse(savedActivity);
//    }

    public ActivityResponse trackActivity(ActivityRequest request) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String userId = authentication.getName();

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("Invalid User: " + userId));

        Activity activity = Activity.builder()
                .user(user)
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMatrix(request.getAdditionalMatrix())
                .build();

        Activity savedActivity = activityRepository.save(activity);

        return mapToResponse(savedActivity);
    }





    private ActivityResponse mapToResponse(Activity savedActivity) {
        ActivityResponse response=new ActivityResponse();
        response.setId(savedActivity.getId());
        response.setType(savedActivity.getType());
        response.setUserId(savedActivity.getUser().getId());
        response.setType(savedActivity.getType());
        response.setDuration(savedActivity.getDuration());
        response.setCaloriesBurned(savedActivity.getCaloriesBurned());
        response.setStartTime(savedActivity.getStartTime());
        response.setAdditionalMatrix(savedActivity.getAdditionalMatrix());
        response.setCreatedAt(savedActivity.getCreatedAt());
        response.setUpdatedAt(savedActivity.getUpdatedAt());

        return response;

    }

    public List<ActivityResponse> getUserActivities(String userId) {
        List<Activity> activityList=activityRepository.findByUserId(userId);
        //activity ko activity response tak list ke through collections in list and then it returns
        return activityList.stream().map(this::mapToResponse).collect(Collectors.toList());
    }
}
