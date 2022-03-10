package cn.code.testsys.web.controller;

import cn.code.testsys.domain.Course;
import cn.code.testsys.service.IAdminService;
import cn.code.testsys.service.ITeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;


    //管理员查询全部课程
    @RequestMapping("/list")
    public ModelAndView courList(){
        ModelAndView mv=new ModelAndView();
        List<Course> courses = adminService.selectCour();
        mv.addObject("courses",courses);
        mv.setViewName("/teacher/course/list");
        return mv;
    }
}
