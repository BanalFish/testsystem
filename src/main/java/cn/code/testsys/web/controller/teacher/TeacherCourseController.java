package cn.code.testsys.web.controller.teacher;

import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.User;
import cn.code.testsys.qo.CourseQueryObject;
import cn.code.testsys.qo.PageResult;
import cn.code.testsys.service.ITeacherCourseService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.Clock;
import java.util.List;

//课程管理
@Controller
@RequestMapping("/teacher")
public class TeacherCourseController {

    @Autowired
    private ITeacherCourseService teacherCourseService;

    //分页功能：跳转有问题，无法跳到/list
    @RequestMapping("/course/listPage")
    public ModelAndView listCourPage(CourseQueryObject queryObject){
        ModelAndView mv=new ModelAndView();
        PageResult<Course> pageResult=teacherCourseService.selectCoursePage(queryObject);
        mv.addObject("pageResult",pageResult);
        mv.setViewName("/teacher/course/list");
        return mv;
    }

    //根据用户查询对应课程
    @RequestMapping("/course/list")
    public ModelAndView courList(){
        ModelAndView mv=new ModelAndView();
        Long teacherId=getTeacherId();
        List<Course> courses = teacherCourseService.selectByUser(teacherId);
        mv.addObject("courses",courses);
        mv.setViewName("/teacher/course/list");
        return mv;
    }

    @RequestMapping("/course/add")
    public ModelAndView courInput(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/teacher/course/add");
        return mv;
    }

    @RequestMapping("/course/save")
    public String save(Course course) {
        //执行保存操作
        Long teacherId=getTeacherId();
        teacherCourseService.save(course,teacherId);
        return "redirect:/teacher/course/list";
    }

    @RequestMapping("/course/delete")
    public String courDel(Long id){
        Long teacherId=getTeacherId();
        teacherCourseService.delete(id,teacherId);
        return "redirect:/teacher/course/list";
    }

    public Long getTeacherId(){
        Subject subject = SecurityUtils.getSubject();
        User principal = (User)subject.getPrincipal();
        Long id = principal.getId();

        return id;
    }


}
