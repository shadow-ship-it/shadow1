package com.lening.stu.mapper;

import com.lening.stu.entity.Grade;
import com.lening.stu.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuMapper {
    List<Student> getAll();

    List<Student> getStuByPage(@Param("sname") String sname, @Param("gname") String gname);

    List<Grade> getGradeList();

    void saveStu(Student student);

    void deleteStuById(@Param("id") Long id);

    Student getStuById(@Param("id") Long id);

    void updStu(Student student);
}
