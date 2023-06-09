package com.it.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    private String uid;
    private int sid;
    private String sname;
    private String head;
    private String text;
    private LocalDateTime time;
}
