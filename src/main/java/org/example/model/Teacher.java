package org.example.model;

public class Teacher {
    int id;
    String name, email;
    Student s1;

    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public void setS1(Student s1){
        this.s1 = s1;
    }
    public Student getS1(){
        return s1;
    }
}
