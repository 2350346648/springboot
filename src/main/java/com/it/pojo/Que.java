package com.it.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Que {
    private Long id;
    private String userid;
    private String username;
    private String que;
    @TableField(fill = FieldFill.INSERT )
    private LocalDateTime time;
    private Integer likes;

}
