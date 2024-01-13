package com.caloriecrowd.repo;

import com.caloriecrowd.entity.NutritionFactsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface NutritionfactsRepository extends JpaRepository<NutritionFactsEntity, Long> {
  @Query("SELECT nf FROM NutritionFact nf WHERE foodName LIKE %:itemName%")
  public List<NutritionFactsEntity> fetchNutritionDetailsByName(@Param("itemName") String itemName);

  @Query(
      "SELECT nf FROM NutritionFact nf WHERE foodName LIKE %:itemName% AND foodCategory= :foodCategory")
  public List<NutritionFactsEntity> fetchNutritionDetailsByNameAndCategory(
      @Param("itemName") String itemName, @Param("foodCategory") String foodCategory);
}
