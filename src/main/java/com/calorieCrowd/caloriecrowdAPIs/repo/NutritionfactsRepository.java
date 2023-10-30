package com.calorieCrowd.caloriecrowdAPIs.repo;

import com.calorieCrowd.caloriecrowdAPIs.entity.NutritionFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NutritionfactsRepository extends JpaRepository<NutritionFact,Long> {
@Query("SELECT nf FROM NutritionFact nf WHERE foodName LIKE %:itemName%")
public List<NutritionFact> fetchNutritionDetailsByName(@Param("itemName") String itemName);

}
