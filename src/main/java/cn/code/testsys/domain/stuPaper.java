package cn.code.testsys.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public class stuPaper {
    private Long id;
    private stuTest stuTest;
    private Long queID;
    private List<String> myanswer;
    private List<Integer> grade;
}
