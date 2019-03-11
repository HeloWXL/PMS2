package com.pms2.yushuting.model;

import java.util.Date;

public class Sign extends SignKey {
    private String studentName;

    private String studentProfession;

    private String studentClass;

    private String studentApartment;

    private Date signDate;

    private Integer isSign;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentProfession() {
        return studentProfession;
    }

    public void setStudentProfession(String studentProfession) {
        this.studentProfession = studentProfession == null ? null : studentProfession.trim();
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass == null ? null : studentClass.trim();
    }

    public String getStudentApartment() {
        return studentApartment;
    }

    public void setStudentApartment(String studentApartment) {
        this.studentApartment = studentApartment == null ? null : studentApartment.trim();
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Integer getIsSign() {
        return isSign;
    }

    public void setIsSign(Integer isSign) {
        this.isSign = isSign;
    }
}