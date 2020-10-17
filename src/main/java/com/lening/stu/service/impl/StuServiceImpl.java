package com.lening.stu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lening.stu.entity.Grade;
import com.lening.stu.entity.Student;
import com.lening.stu.mapper.StuMapper;
import com.lening.stu.service.StuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Resource
    private StuMapper stuMapper;
    @Override
    public List<Student> getAll() {
        return stuMapper.getAll();
    }

    @Override
    public PageInfo<Student> findByPage(Integer page, Integer limit, String sname, String gname) {
        //启用分页插件
        PageHelper.startPage(page,limit);
        //查询
        List<Student> list = stuMapper.getStuByPage(sname,gname);
        //创建pageInfo对象,将List放进pageInfo对象中
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Grade> getGradeList() {
        return stuMapper.getGradeList();
    }

    @Override
    public void saveStu(Student student) {
        stuMapper.saveStu(student);
    }

    @Override
    public void deleteStuById(Long id) {
        stuMapper.deleteStuById(id);
    }

    @Override
    public Student getStuById(Long id) {
        return stuMapper.getStuById(id);
    }

    @Override
    public void updStu(Student student) {
        stuMapper.updStu(student);
    }
}
