package cn.code.testsys.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Test {
    private Long id;
    private String name;
    private TestPaper testPaper;
    private Date startTime;
    private Date endTime;
    private int status;
}
