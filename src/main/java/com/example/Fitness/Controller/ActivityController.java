package com.example.Fitness.Controller;


import com.example.Fitness.DTO.ActivityRequest;
import com.example.Fitness.DTO.ActivityResponse;
import com.example.Fitness.Service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/activities")
@RequiredArgsConstructor

public class ActivityController {

    private final ActivityService activityService;

//    @PostMapping
//    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request){
//        return ResponseEntity.ok(activityService.trackActivity(request));
//    }


    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(
            @RequestBody ActivityRequest request) {

        return ResponseEntity.ok(activityService.trackActivity(request));
    }


    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivity(@RequestHeader(value = "X-User-ID") String userId){
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }
}
