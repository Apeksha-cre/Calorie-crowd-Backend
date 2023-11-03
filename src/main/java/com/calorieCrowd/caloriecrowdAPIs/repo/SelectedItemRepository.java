package com.calorieCrowd.caloriecrowdAPIs.repo;

import com.calorieCrowd.caloriecrowdAPIs.entity.SelectedItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface SelectedItemRepository extends JpaRepository<SelectedItems, UUID> {

    @Query("SELECT totalCalorie FROM SelectedItems s Where s.date=:date")
    public List<Integer> fatchCalorieOnDate(@Param("date") String date);
}
