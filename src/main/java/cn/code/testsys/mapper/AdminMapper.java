package cn.code.testsys.mapper;

import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.Question;

import java.util.List;

public interface AdminMapper {
    /**
     * 查询全部课程信息
     * @return
     */
    List<Course> selectCour();

    /**
     * 返回全部题目
     * @return
     */
    List<Question> selectQues();

    /**
     * 根据题目id返回题目
     */
    Question selectByQueId(Long queId);
}
