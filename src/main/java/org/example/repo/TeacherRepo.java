package org.example.repo;

import org.example.model.Student;
import org.example.model.Teacher;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherRepo implements TeacherRepoImpl{

    String url = "jdbc:mysql://localhost:3306/testteacher";
    String name = "root";
    String pass = "";
    @Override
    public void insertTeacher(Teacher t1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,name,pass);
            Statement st = con.createStatement();
            st.executeUpdate("insert into teacher values('"+t1.getId()+"','"+
                                                            t1.getName()+"','"+
                                                            t1.getEmail()+"')");
            st.executeUpdate("insert into student values('"+t1.getS1().getId()+"','"+
                                                        t1.getS1().getName()+"','"+
                                                        t1.getS1().getEmail()+"')");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void multipleTeacher(List<Teacher> teacherList){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,name,pass);
            Statement st = con.createStatement();
            for (int i=0;i<teacherList.size();i++) {
                st.executeUpdate("insert into teacher value('"+teacherList.get(i).getId()+"','"+
                                                                teacherList.get(i).getName()+"','"+
                                                                teacherList.get(i).getEmail()+"')");
            }
            for (int i=0;i<teacherList.size();i++) {
                st.executeUpdate("insert into student value('"+teacherList.get(i).getS1().getId()+"','"+
                        teacherList.get(i).getS1().getName()+"','"+
                        teacherList.get(i).getS1().getEmail()+"')");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Teacher selectTeacher(int id,int sId){
        Teacher t1 = new Teacher();
        Student s1 = new Student();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,name,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from teacher where id = '"+id+"'");
            while (rs.next()){
                t1.setId(rs.getInt(1));
                t1.setName(rs.getString(2));
                t1.setEmail(rs.getString(3));
            }
            ResultSet rs1 = st.executeQuery("select * from student where id = '"+sId+"'");
            while (rs1.next()){
                s1.setId(rs1.getInt(1));
                s1.setName(rs1.getString(2));
                s1.setEmail(rs1.getString(3));
            }
            t1.setS1(s1);
        }catch (Exception e){
            System.out.println(e);
        }
        return t1;
    }

    @Override
    public Teacher updateSingle(Teacher t1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,name,pass);
            Statement st = con.createStatement();
            st.executeUpdate("update teacher set name='"+t1.getName()+"',email='"+
                                                    t1.getEmail()+"' where id='"+
                                                t1.getId()+"'");
            st.executeUpdate("update student set name='"+t1.getS1().getName()+"',email='"+
                    t1.getS1().getEmail()+"' where id='"+
                    t1.getS1().getId()+"'");
        }catch (Exception e){
            System.out.println(e);
        }
        return selectTeacher(t1.getId(),t1.getS1().getId());
    }

    @Override
    public List<Teacher> selectMultiple(List<Integer> ids,List<Integer> sIds) {
        List<Teacher> teacherList = new ArrayList<>();
        List<Teacher> teacherList1 = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,name,pass);
            Statement st = con.createStatement();
            for (int i=0;i<ids.size();i++) {
                ResultSet rs = st.executeQuery("select * from teacher where id='"+ids.get(i)+"'");
                while (rs.next()){
                    Teacher t1 = new Teacher();
                    t1.setId(rs.getInt(1));
                    t1.setName(rs.getString(2));
                    t1.setEmail(rs.getString(3));
                    teacherList.add(t1);
                }
            }
            for (int i=0;i<ids.size();i++) {
                ResultSet rs = st.executeQuery("select * from student where id='"+sIds.get(i)+"'");
                while (rs.next()){
                    Student s1 = new Student();
                    s1.setId(rs.getInt(1));
                    s1.setName(rs.getString(2));
                    s1.setEmail(rs.getString(3));
                    studentList.add(s1);
                }
            }
            for (int i=0;i<teacherList.size();i++){
                Teacher t1 = teacherList.get(i);
                t1.setS1(studentList.get(i));
                teacherList1.add(t1);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return teacherList1;
    }

    @Override
    public List<Teacher> selectAll() {
        List<Teacher> teacherList = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,name,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from teacher");
            while (rs.next()){
                Teacher t1 = new Teacher();
                t1.setId(rs.getInt(1));
                t1.setName(rs.getString(2));
                t1.setEmail(rs.getString(3));
                teacherList.add(t1);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return teacherList;
    }
    @Override
    public List<Teacher> updateMultiple( List<Teacher> teacherList){
        List<Integer> ids = new ArrayList<>();
        List<Integer> sIds = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,name,pass);
            Statement st = con.createStatement();
            for (int i = 0 ; i<teacherList.size();i++) {
                st.executeUpdate("Update teacher set name='" + teacherList.get(i).getName() + "',email='"+
                        teacherList.get(i).getEmail()+"' where id = '"+
                        teacherList.get(i).getId()+"'");
                ids.add(teacherList.get(i).getId());
                sIds.add(teacherList.get(i).getS1().getId());
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return selectMultiple(ids,sIds);
    }

    @Override
    public Boolean deleteSingle(int id){
        Boolean result = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,name,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from teacher where id='"+id+"'");
            if (count>0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}
