package org.example.controller;

import org.example.model.Teacher;
import org.example.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherServiceImpl service;

    @RequestMapping("/insertSingle")
    @ResponseBody
    void insertTeacher(@RequestBody Teacher t1){
        service.insertTeacher(t1);
    }

    @RequestMapping("/insertMultiple")
    @ResponseBody
    void multipleTeacher(@RequestBody List<Teacher> teacherList){
        service.multipleTeacher(teacherList);
    }

    @RequestMapping("/selectSingle")
    @ResponseBody
    Teacher selectTeacher(@RequestParam int id,@RequestParam int sId){
        return service.selectTeacher(id,sId);
    }

    @RequestMapping("/selectMultiple")
    @ResponseBody
    List<Teacher> selectMultiple(@RequestParam List<Integer> ids,@RequestParam List<Integer> sIds){
        return service.selectMultiple(ids,sIds);
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    List<Teacher> selectAll(){
        return service.selectAll();
    }

    @RequestMapping("/updateSingle")
    @ResponseBody
    Teacher updateSingle(@RequestBody Teacher t1){
        return service.updateSingle(t1);
    }
    @RequestMapping("/updateMultiple")
    @ResponseBody
    List<Teacher> updateMultiple(@RequestBody List<Teacher> teacherList){
        return service.updateMultiple(teacherList);
    }

    @RequestMapping("/deleteSingle")
    @ResponseBody
    Boolean deleteSingle(@RequestParam int id){
        return service.deleteSingle(id);
    }
}
