package com.pms2.yushuting.model;

public class Student {
    private Integer studentId;

    private String studentNo;

    private String studentName;

    private String studentPassword;

    private String studentClass;

    private String studentHomeaddress;

    private String studentApartment;

    private String studentPhone;

    private String sutdnetSex;

    private String studentProfession;

    private Integer studentAge;

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword == null ? null : studentPassword.trim();
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass == null ? null : studentClass.trim();
    }

    public String getStudentHomeaddress() {
        return studentHomeaddress;
    }

    public void setStudentHomeaddress(String studentHomeaddress) {
        this.studentHomeaddress = studentHomeaddress == null ? null : studentHomeaddress.trim();
    }

    public String getStudentApartment() {
        return studentApartment;
    }

    public void setStudentApartment(String studentApartment) {
        this.studentApartment = studentApartment == null ? null : studentApartment.trim();
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone == null ? null : studentPhone.trim();
    }

    public String getSutdnetSex() {
        return sutdnetSex;
    }

    public void setSutdnetSex(String sutdnetSex) {
        this.sutdnetSex = sutdnetSex == null ? null : sutdnetSex.trim();
    }

    public String getStudentProfession() {
        return studentProfession;
    }

    public void setStudentProfession(String studentProfession) {
        this.studentProfession = studentProfession == null ? null : studentProfession.trim();
    }
}