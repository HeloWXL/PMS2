package com.pms2.yushuting.model;

import java.util.Date;

public class Week {
    private Integer weekId;

    private Integer studentNo;

    private String studentClass;

    private String studentProfession;

    private String studentApartment;

    private String studentName;

    private String weekSummary;

    private Date weekSummaryDate;

    private Integer isRead;

    public Integer getWeekId() {
        return weekId;
    }

    public void setWeekId(Integer weekId) {
        this.weekId = weekId;
    }

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass == null ? null : studentClass.trim();
    }

    public String getStudentProfession() {
        return studentProfession;
    }

    public void setStudentProfession(String studentProfession) {
        this.studentProfession = studentProfession == null ? null : studentProfession.trim();
    }

    public String getStudentApartment() {
        return studentApartment;
    }

    public void setStudentApartment(String studentApartment) {
        this.studentApartment = studentApartment == null ? null : studentApartment.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getWeekSummary() {
        return weekSummary;
    }

    public void setWeekSummary(String weekSummary) {
        this.weekSummary = weekSummary == null ? null : weekSummary.trim();
    }

    public Date getWeekSummaryDate() {
        return weekSummaryDate;
    }

    public void setWeekSummaryDate(Date weekSummaryDate) {
        this.weekSummaryDate = weekSummaryDate;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }
}