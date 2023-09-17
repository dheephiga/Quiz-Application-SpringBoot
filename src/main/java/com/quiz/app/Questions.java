package com.quiz.app;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Questions {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String category;
    private String difficultylevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questiontitle;
    private String rightanswer;
}
