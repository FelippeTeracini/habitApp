package com.example.habitapp.service;

import com.example.habitapp.dao.HabitRepository;
import com.example.habitapp.dto.HabitCreateRequest;
import com.example.habitapp.dto.HabitResponse;
import com.example.habitapp.model.Account;
import com.example.habitapp.model.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HabitService {

    @Autowired
    HabitRepository habitRepository;
    @Autowired
    AccountService accountService;

    public List<HabitResponse> getAllHabitsByAccountId(Integer accountId) {
        List<Habit> habits = habitRepository.findByAccountAccountId(accountId);
        return habits.stream().map(this::createHabitResponse).collect(Collectors.toList());
    }

    public HabitResponse getHabitByAccountIdAndHabitId(Integer accountId, Integer habitId) throws Exception {
        Optional<Habit> habit = habitRepository.findByAccountIdAndHabitId(accountId, habitId);
        if(habit.isEmpty()){
            throw new Exception(String.format("Could not find habit with habitId %d and accountId %d", habitId, accountId));
        }
        return createHabitResponse(habit.get());
    }

    public void createHabit(Integer accountId, HabitCreateRequest habitDTO) throws Exception {
        try {
            Account account = accountService.getAccountById(accountId);
            Habit habit = new Habit();
            habit.setTitle(habitDTO.getTitle());
            habit.setDescription(habitDTO.getDescription());
            habit.setAccount(account);
            habitRepository.save(habit);
        } catch (Exception e){
            throw new Exception(String.format("Could not create habit for account %d", accountId));
        }
    }

    private HabitResponse createHabitResponse(Habit habit){
        return HabitResponse.builder()
                .habitId(habit.getHabitId())
                .title(habit.getTitle())
                .description(habit.getDescription())
                .creationDate(habit.getCreationDate())
                .build();
    }
}
