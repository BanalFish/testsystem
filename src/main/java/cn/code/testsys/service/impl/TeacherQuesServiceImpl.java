package cn.code.testsys.service.impl;

import cn.code.testsys.domain.Question;
import cn.code.testsys.mapper.TeacherQuesMapper;
import cn.code.testsys.service.ITeacherQuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeacherQuesServiceImpl implements ITeacherQuesService {

    @Autowired
    private TeacherQuesMapper teacherQuesMapper;

    @Override
    public void insert(Question question) {
        teacherQuesMapper.insert(question);
    }

    @Override
    public void delete(Long id) {
        teacherQuesMapper.delete(id);
    }

    @Override
    public void update(Question question) {
        teacherQuesMapper.delete(question.getId());
        teacherQuesMapper.insert(question);
    }


}
