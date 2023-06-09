package com.it.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Que {
    private Integer qid;
    private Integer good;
    private Integer likes;
    private String uid;
    private String uname;
    private String que;
    private LocalDateTime time;
}
