package cn.code.testsys.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private Long id;
    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    private int count;

}
