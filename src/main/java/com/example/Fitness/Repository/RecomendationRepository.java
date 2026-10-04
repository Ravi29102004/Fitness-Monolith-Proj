package com.example.Fitness.Repository;

import com.example.Fitness.model.Recommendations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecomendationRepository extends JpaRepository<Recommendations, String> {
    List<Recommendations> findByUserId(String userId);

    List<Recommendations> findByActivityId(String activityId);
}
