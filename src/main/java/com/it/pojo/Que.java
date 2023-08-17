package com.it.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Que {
    private Integer id;
    private String uid;
    private String uname;
    private String que;
    private LocalDateTime time;

    private Integer likes;
}
