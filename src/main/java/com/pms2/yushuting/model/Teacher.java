package com.pms2.yushuting.model;

public class Teacher {
    private Integer teacherId;

    private Integer teacherNo;

    private String teacherPassword;

    private String teacherName;

    private String teacherSex;

    private String teacherApartment;

    private String teacherHomeaddress;

    private String teacherPhone;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(Integer teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword == null ? null : teacherPassword.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex == null ? null : teacherSex.trim();
    }

    public String getTeacherApartment() {
        return teacherApartment;
    }

    public void setTeacherApartment(String teacherApartment) {
        this.teacherApartment = teacherApartment == null ? null : teacherApartment.trim();
    }

    public String getTeacherHomeaddress() {
        return teacherHomeaddress;
    }

    public void setTeacherHomeaddress(String teacherHomeaddress) {
        this.teacherHomeaddress = teacherHomeaddress == null ? null : teacherHomeaddress.trim();
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone == null ? null : teacherPhone.trim();
    }
}