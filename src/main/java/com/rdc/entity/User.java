package com.rdc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table( name = "user")
public class User {

    @Id
    @GenericGenerator(name = "NativeTableGenerator", strategy = "native")
    @GeneratedValue(generator = "NativeTableGenerator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @Column(name = "sex")
    private String sex;

    @Column(name = "major_and_class")
    private String majorAndClass;  // 学院专业班级

    @Column(name = "duties")
    private String duties; // 职务

    @Column(name = "phone")
    private String phone;

    @Column(name = "short_number")
    private String shortNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "qq")
    private String QQ;

    @Column(name = "organize")
    private String organize; //方向   前端，后台，安卓，大数据

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "introduce")
    private String introduce;

    @Column(name = "purpose")
    private String purpose;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", sex=" + sex +
                ", majorAndClass='" + majorAndClass + '\'' +
                ", duties='" + duties + '\'' +
                ", phone='" + phone + '\'' +
                ", shortNumber='" + shortNumber + '\'' +
                ", email='" + email + '\'' +
                ", QQ='" + QQ + '\'' +
                ", organize=" + organize +
                ", speciality='" + speciality + '\'' +
                ", introduce='" + introduce + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajorAndClass() {
        return majorAndClass;
    }

    public void setMajorAndClass(String majorAndClass) {
        this.majorAndClass = majorAndClass;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShortNumber() {
        return shortNumber;
    }

    public void setShortNumber(String shortNumber) {
        this.shortNumber = shortNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getOrganize() {
        return organize;
    }

    public void setOrganize(String organize) {
        this.organize = organize;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
