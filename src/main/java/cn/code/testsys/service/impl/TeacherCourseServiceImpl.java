package cn.code.testsys.service.impl;

import cn.code.testsys.domain.Course;
import cn.code.testsys.mapper.TeacherCourseMapper;
import cn.code.testsys.qo.CourseQueryObject;
import cn.code.testsys.qo.PageResult;
import cn.code.testsys.service.ITeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherCourseServiceImpl implements ITeacherCourseService {

    @Autowired
    private TeacherCourseMapper teacherCourseMapper;

    @Override
    public PageResult<Course> selectCoursePage(CourseQueryObject queryObject) {
        PageResult<Course> pageResult = null;
        int totalCount = teacherCourseMapper.selectCount();
        if (totalCount == 0){
            //表里面 没有我们查询的数据
            pageResult = new PageResult<>(queryObject.getCurrentPage(),queryObject.getPageSize(),
                    0,new ArrayList<>());
        }else{
            List<Course> courseList = teacherCourseMapper.selectCoursePage(queryObject);
            pageResult = new PageResult<>(queryObject.getCurrentPage(),queryObject.getPageSize(),
                    totalCount,courseList);
        }
        return pageResult;
    }

    @Override
    public void delete(Long courID,Long teacherID) {
        teacherCourseMapper.delTeachAndCourse(courID,teacherID);
        teacherCourseMapper.delete(courID);
    }

    @Override
    public void save(Course course,Long teacherID) {
        teacherCourseMapper.insert(course);
        teacherCourseMapper.addTeachAndCourse(course.getId(), teacherID);
    }

    @Override
    public List<Course> selectByUser(Long id) {
        return teacherCourseMapper.selectByUser(id);
    }
}
