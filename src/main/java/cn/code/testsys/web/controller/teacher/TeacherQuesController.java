package cn.code.testsys.web.controller.teacher;

import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.Question;
import cn.code.testsys.mapper.AdminMapper;
import cn.code.testsys.service.ITeacherCourseService;
import cn.code.testsys.service.ITeacherQuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//题库管理
@Controller
@RequestMapping("/teacher")
public class TeacherQuesController {

    @Autowired
    private ITeacherQuesService iTeacherQuesMapper;
    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping("/ques/list")
    public ModelAndView quesList(){
        ModelAndView mv=new ModelAndView();
        List<Question> questions =adminMapper.selectQues();
        mv.addObject("questions",questions);
        mv.setViewName("/teacher/ques/list");
        return mv;
    }

    @RequestMapping("/ques/input")
    public ModelAndView quesInput(Long id){
        ModelAndView mv=new ModelAndView();

        if(id!=null){
            Question que = adminMapper.selectByQueId(id);
            mv.addObject("que",que);
        }

        List<Course> courses = adminMapper.selectCour();
        mv.addObject("courses",courses);
        mv.setViewName("/teacher/ques/input");
        return mv;
    }

    @RequestMapping("/ques/save")
    public String save(Question question) {
        //执行保存操作
        if(question.getId()!=null){
            iTeacherQuesMapper.insert(question);
        }
        else{
            iTeacherQuesMapper.update(question);
        }
        return "redirect:/teacher/ques/list";
    }

    @RequestMapping("/ques/delete")
    public String courDel(Long id){
        iTeacherQuesMapper.delete(id);
        return "redirect:/teacher/ques/list";
    }

}
