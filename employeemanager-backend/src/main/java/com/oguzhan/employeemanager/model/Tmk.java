package com.oguzhan.employeemanager.model;

import jakarta.persistence.*;

@Entity(name = "Tmk")
@Table(name = "tmk")
public class Tmk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String hui;
    private String code;
    private String dutyName;

    public Tmk() {
    }

    public Tmk(String hui, String code, String dutyName) {
        this.hui = hui;
        this.code = code;
        this.dutyName = dutyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHui() {
        return hui;
    }

    public void setHui(String hui) {
        this.hui = hui;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    @Override
    public String toString() {
        return "Tmk{" +
                "id=" + id +
                ", hui='" + hui + '\'' +
                ", code='" + code + '\'' +
                ", dutyName='" + dutyName + '\'' +
                '}';
    }
}
