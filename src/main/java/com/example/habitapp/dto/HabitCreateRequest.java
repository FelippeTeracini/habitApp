package com.example.habitapp.dto;

import lombok.Data;

@Data
public class HabitCreateRequest {
    private String title;
    private String description;
}
