package com.example.habitapp.controller;

import com.example.habitapp.dto.HabitCompletionResponse;
import com.example.habitapp.service.HabitCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account/{accountId}/habit/completion")
public class HabitCompletionController {

    @Autowired
    HabitCompletionService habitCompletionService;
    @GetMapping("{habitCompletionId}")
    public ResponseEntity<List<HabitCompletionResponse>> findAllHabitCompletionsByAccountIdAndHabitId(@PathVariable Integer accountId, @RequestParam Integer habitId){
        List<HabitCompletionResponse> habitCompletionResponse = habitCompletionService.findAllHabitCompletionsByAccountIdAndHabitId(accountId, habitId);
        return new ResponseEntity<>(habitCompletionResponse, HttpStatus.OK);
    }
}
