package cn.code.testsys.domain;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TestPaper {
    private Long id;
    private String name;
    private int status;
    private String allAnswer;
}
