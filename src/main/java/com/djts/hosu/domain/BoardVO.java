package com.djts.hosu.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardVO {

    //데이터베이스의 테이블과 거의 맞춰서 만들면 된다고 생각하면 됨
    private Long bno; //jpa할때 보통 long을 씀
    private String title;
    private String content;
    private String writer;

    //날짜가 조금 달라짐 옛날에는 DateTime을 썼는데 java1.8버전 이상에서는 LocalDate 씀
    private LocalDateTime writeDate;
    private LocalDateTime updateDate;

}
