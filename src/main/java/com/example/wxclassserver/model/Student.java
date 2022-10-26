package com.example.wxclassserver.model;

public class Student {
    Integer sno;
    String sname;
    Integer sage;
    String gender;
    Integer grade;
    Integer sphone;
    String intro;
    Integer status;
    String smail;

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", gender='" + gender + '\'' +
                ", grade=" + grade +
                ", sphone=" + sphone +
                ", intro='" + intro + '\'' +
                ", status=" + status +
                ", smail='" + smail + '\'' +
                '}';
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getSphone() {
        return sphone;
    }

    public void setSphone(Integer sphone) {
        this.sphone = sphone;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSmail() {
        return smail;
    }

    public void setSmail(String smail) {
        this.smail = smail;
    }
}
