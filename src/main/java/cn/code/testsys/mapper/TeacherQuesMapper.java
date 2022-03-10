package cn.code.testsys.mapper;

import cn.code.testsys.domain.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherQuesMapper {

    /**
     * 根据courID返回题目信息
     * @return
     */
    List<Question> quesList(Long courID);
    Question getQueById(Long id);

    /**
     * 新增题目
     * @param question
     */
    void insert(Question question);

    void delete(Long id);


}
