package cn.code.testsys.service;

import cn.code.testsys.domain.Course;
import cn.code.testsys.qo.CourseQueryObject;
import cn.code.testsys.qo.PageResult;

import java.util.List;

public interface ITeacherCourseService {

    PageResult<Course> selectCoursePage(CourseQueryObject queryObject);

    void delete(Long courID,Long teacherID);

    //本系统功能不支持对已有课程进行编辑信息，这里的save只能新增课程
    void save(Course course,Long teacherID);

    List<Course> selectByUser(Long id);
}
