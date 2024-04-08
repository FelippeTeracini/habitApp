package com.example.habitapp.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class HabitCompletionResponse {

    private Integer habitCompletionId;
    private Boolean completion;
    private Date completionDate;
}
