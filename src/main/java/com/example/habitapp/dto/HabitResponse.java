package com.example.habitapp.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class HabitResponse {

    private Integer habitId;
    private String title;
    private String description;
    private Date creationDate;
}
