package cn.code.testsys.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Question {
    private Long id;
    private String problem;
    private int score;
    private int type;
    private Course course;
    private int degree;//难易程度

}
