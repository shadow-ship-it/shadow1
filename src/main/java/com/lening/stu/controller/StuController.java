package com.lening.stu.controller;

import com.github.pagehelper.PageInfo;
import com.lening.stu.entity.Grade;
import com.lening.stu.entity.Student;
import com.lening.stu.service.StuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sc")
public class StuController {

    @Resource
    private StuService stuService;

    /**
     * 查询
     * @param model
     * @return
     */
    @RequestMapping("/query")
    public String query(Model model){
        List<Student> list = stuService.getAll();
        model.addAttribute("list",list);
        return "stu_list";
    }

    /**
     * 模糊加分页
     * @param model
     * @param page
     * @param limit
     * @param sname
     * @param gname
     * @return
     */
    @RequestMapping("/findByPage")
    public String findByPage(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "2") Integer limit, String sname, String gname){
        System.out.println(page+"/"+limit+"/"+sname+"/"+gname);
        PageInfo<Student> pageInfo = stuService.findByPage(page,limit,sname,gname);
        model.addAttribute("pageInfo",pageInfo);
        return "stu_list";
    }

    /**
     * 跳转添加页面
     * @return
     */
    @RequestMapping("/toSaveStu")
    public String toSaveStu(Model model){
        List<Grade> gradeList = stuService.getGradeList();
        model.addAttribute("gradeList",gradeList);
        System.out.println(gradeList);
        return "stu_add";
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping("/saveStu")
    public String saveStu(Student student){
        System.out.println(student);
        stuService.saveStu(student);
        return "redirect:findByPage";
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("/deleteStuById")
    public String deleteStuById(Long id){
        System.out.println(id);
        stuService.deleteStuById(id);
        return "redirect:findByPage";
    }

    /**
     * 跳转修改页面
     * @return
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Long id,Model model){
        List<Grade> gradeList = stuService.getGradeList();
        model.addAttribute("gradeList",gradeList);
        Student student = stuService.getStuById(id);
        model.addAttribute("student",student);
        System.out.println(student);
        return "stu_upd";
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping("/updStu")
    public String updStu(Student student){
        System.out.println(student);
        stuService.updStu(student);
        return "redirect:findByPage";
    }
}
