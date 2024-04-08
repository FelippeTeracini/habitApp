package com.example.habitapp.dao;

import com.example.habitapp.model.HabitCompletion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitCompletionRepository extends JpaRepository<HabitCompletion, Integer> {

    @Query(value = "SELECT * FROM habit_completion hc INNER JOIN habit h ON (h.habit_id = hc.habit_id) WHERE hc.habit_id = :habitId AND h.account_id = :accountId", nativeQuery = true)
    List<HabitCompletion> findAllHabitCompletionsByAccountIdAndHabitId(Integer accountId, Integer habitId);
}
