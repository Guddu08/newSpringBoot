package org.example.service;

import org.example.model.Teacher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TeacherServiceImpl {
    void insertTeacher(Teacher t1);
    void multipleTeacher(List<Teacher> teacherList);
    Teacher selectTeacher(int id,int sId);
    Teacher updateSingle(Teacher t1);
    List<Teacher> selectMultiple(List<Integer> ids,List<Integer> sIds);
    List<Teacher> selectAll();
    List<Teacher> updateMultiple( List<Teacher> teacherList);
    Boolean deleteSingle(int id);
}
