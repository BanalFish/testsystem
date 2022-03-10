package cn.code.testsys.service;

import cn.code.testsys.domain.Question;


public interface ITeacherQuesService {

    void insert(Question question);

    void delete(Long id);

    void update(Question question);
}
