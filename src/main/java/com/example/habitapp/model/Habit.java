package com.example.habitapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habit_id")
    private Integer habitId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @CreatedDate
    @Column(name = "creation_date")
    private Date creationDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    private List<HabitCompletion> habitCompletionList;
}
