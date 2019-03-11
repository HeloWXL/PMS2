package com.pms2.yushuting.model;

import java.util.Date;

public class Summary {
    private Integer summaryId;

    private String studentNo;

    private String studentClass;

    private String studentProfession;

    private String studentApartment;

    private String summary;

    private Date summaryDatetime;

    private Integer isRead;

    private String studentName;

    public Integer getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(Integer summaryId) {
        this.summaryId = summaryId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Date getSummaryDatetime() {
        return summaryDatetime;
    }

    public void setSummaryDatetime(Date summaryDatetime) {
        this.summaryDatetime = summaryDatetime;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }
}