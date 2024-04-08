package com.example.habitapp.dao;

import com.example.habitapp.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Integer> {
    List<Habit> findByAccountAccountId(Integer accountId);

    @Query(value = "SELECT * FROM habit h WHERE h.account_id = :accountId AND h.habit_id = :habitId", nativeQuery = true)
    Optional<Habit> findByAccountIdAndHabitId(Integer accountId, Integer habitId);
}
