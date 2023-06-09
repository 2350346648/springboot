package com.it.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private int qid;
    private String uid;


    private String uname;
    private String head;
    private String answer;
    private LocalDateTime time;
}
