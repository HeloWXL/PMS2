package com.pms2.yushuting.model;

public class Company {
    private Integer companyId;

    private String companyName;

    private String location;

    private String peopleCount;

    private String companyImage;

    private String category;

    private String likeman;

    private String likeManPhone;

    private String urlAddress;

    private String avgSalary;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(String peopleCount) {
        this.peopleCount = peopleCount == null ? null : peopleCount.trim();
    }

    public String getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage == null ? null : companyImage.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getLikeman() {
        return likeman;
    }

    public void setLikeman(String likeman) {
        this.likeman = likeman == null ? null : likeman.trim();
    }

    public String getLikeManPhone() {
        return likeManPhone;
    }

    public void setLikeManPhone(String likeManPhone) {
        this.likeManPhone = likeManPhone == null ? null : likeManPhone.trim();
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress == null ? null : urlAddress.trim();
    }

    public String getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(String avgSalary) {
        this.avgSalary = avgSalary == null ? null : avgSalary.trim();
    }
}