package com.example.habitapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class HabitCompletion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habit_completion_id")
    private Integer habitCompletionId;
    @Column(name = "completion")
    private Boolean completion;
    @Column(name = "insert_date")
    private Date completionDate;
}
