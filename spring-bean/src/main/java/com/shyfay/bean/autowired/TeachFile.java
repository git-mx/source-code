package com.shyfay.bean.autowired;

import lombok.Data;

/**
 * @author mx
 * @since 2019/4/26
 */
@Data
public class TeachFile {
    private Teacher teacher;
    private Student student;
    public TeachFile() {
    }
    public TeachFile(Teacher teacher, Student student) {
        this.teacher = teacher;
        this.student = student;
    }

    public void print() {
        System.out.println("------教师信息------");
        System.out.println("姓名：" + teacher.getName());
        System.out.println("年龄：" + teacher.getAge());
        System.out.println("性别：" + teacher.getSex());
        System.out.println();
        System.out.println("------学生信息------");
        System.out.println("学号：" + student.getID());
        System.out.println("姓名：" + student.getName());
        System.out.println("年龄：" + student.getAge());
        System.out.println("性别：" + student.getSex());
    }

}
