package cn.code.testsys.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter

public class stuTest {
    private Long id;
    private Test test;
    private User student;
    private int total;
    private Date finTime;
    private int finStatus;
}
