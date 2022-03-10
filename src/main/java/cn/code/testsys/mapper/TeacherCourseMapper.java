package cn.code.testsys.mapper;

import cn.code.testsys.domain.Course;
import cn.code.testsys.qo.CourseQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherCourseMapper {

    List<Course> selectByUser(Long id);

    /**
     * 查询课程分页
     */
    List<Course> selectCoursePage(@Param("queryObject") CourseQueryObject queryObject);

    /**
     * 查询数据总条数
     */
    int selectCount();

    /**
     * 根据id删除信息
     */
    void delete(Long id);
    void delTeachAndCourse(@Param("courID") Long courID,@Param("teacherID")Long teacherID);

    /**
     * 插入课程信息
     * @param course
     */
    void insert(Course course);
    void addTeachAndCourse(@Param("courID") Long courID,@Param("teacherID")Long teacherID);

}
