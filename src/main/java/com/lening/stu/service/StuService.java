package com.lening.stu.service;

import com.github.pagehelper.PageInfo;
import com.lening.stu.entity.Grade;
import com.lening.stu.entity.Student;

import java.util.List;

public interface StuService {
    List<Student> getAll();

    PageInfo<Student> findByPage(Integer page, Integer limit, String sname, String gname);

    List<Grade> getGradeList();

    void saveStu(Student student);

    void deleteStuById(Long id);

    Student getStuById(Long id);

    void updStu(Student student);
}
