package com.calorieCrowd.caloriecrowdAPIs.repo;

import com.calorieCrowd.caloriecrowdAPIs.entity.NutritionFact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutritionfactsRepository extends JpaRepository<NutritionFact,Long> {

}
