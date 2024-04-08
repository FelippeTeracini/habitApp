package com.example.habitapp.controller;

import com.example.habitapp.dto.HabitCreateRequest;
import com.example.habitapp.dto.HabitResponse;
import com.example.habitapp.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account/{accountId}/habit")
public class HabitController {

    @Autowired
    HabitService habitService;

    @GetMapping("")
    public ResponseEntity<List<HabitResponse>> getAllHabitsByAccountId(@PathVariable Integer accountId){
        List<HabitResponse> habits = habitService.getAllHabitsByAccountId(accountId);
        return new ResponseEntity<>(habits, HttpStatus.OK);
    }

    @GetMapping("{habitId}")
    public ResponseEntity<HabitResponse> getHabitByAccountIdAndHabitId(@PathVariable Integer accountId, @PathVariable Integer habitId){
        try{
            HabitResponse habitResponse = habitService.getHabitByAccountIdAndHabitId(accountId, habitId);
            return new ResponseEntity<>(habitResponse, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    public ResponseEntity<String> createHabit(@PathVariable Integer accountId, @RequestBody HabitCreateRequest habitDTO){
        try {
            habitService.createHabit(accountId, habitDTO);
            return new ResponseEntity<>("Habit created", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
