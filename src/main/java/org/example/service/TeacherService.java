package org.example.service;

import org.example.model.Teacher;
import org.example.repo.TeacherRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService implements TeacherServiceImpl{

    @Autowired
    private TeacherRepoImpl repo;
    @Override
    public void insertTeacher(Teacher t1){
        repo.insertTeacher(t1);
    }

    @Override
    public void multipleTeacher(List<Teacher> teacherList){
        repo.multipleTeacher(teacherList);
    }

    @Override
    public Teacher selectTeacher(int id,int sId){
        return repo.selectTeacher(id,sId);
    }

    @Override
    public Teacher updateSingle(Teacher t1){
        return repo.updateSingle(t1);
    }

    @Override
    public List<Teacher> selectMultiple(List<Integer> ids,List<Integer> sIds) {
//        return repo.selectMultiple(ids,sIds);
        List<Teacher> teacherList = new ArrayList<>();
        for (int i=0;i<ids.size();i++){
            teacherList.add(selectTeacher(ids.get(i),sIds.get(i)));
        }
        return teacherList;
    }

    @Override
    public List<Teacher> selectAll() {
        return repo.selectAll();
    }
    @Override
    public List<Teacher> updateMultiple( List<Teacher> teacherList){
        return repo.updateMultiple(teacherList);
    }

    @Override
    public Boolean deleteSingle(int id){
        return repo.deleteSingle(id);
    }
}
