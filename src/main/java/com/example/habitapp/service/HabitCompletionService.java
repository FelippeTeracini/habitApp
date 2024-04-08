package com.example.habitapp.service;

import com.example.habitapp.dao.HabitCompletionRepository;
import com.example.habitapp.dto.HabitCompletionResponse;
import com.example.habitapp.model.HabitCompletion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabitCompletionService {

    @Autowired
    HabitCompletionRepository habitCompletionRepository;

    public List<HabitCompletionResponse> findAllHabitCompletionsByAccountIdAndHabitId(Integer accountId, Integer habitId) {
        List<HabitCompletion> habitCompletions = habitCompletionRepository.findAllHabitCompletionsByAccountIdAndHabitId(accountId, habitId);
        return habitCompletions.stream().map(this::createHabitCompletionResponse).collect(Collectors.toList());
    }

    private HabitCompletionResponse createHabitCompletionResponse(HabitCompletion habitCompletion){
        return HabitCompletionResponse.builder()
                .habitCompletionId(habitCompletion.getHabitCompletionId())
                .completion(habitCompletion.getCompletion())
                .completionDate(habitCompletion.getCompletionDate())
                .build();
    }
}
