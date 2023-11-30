package com.oguzhan.employeemanager.dto;

public class TmkDTO {
    private Long id;
    private String hui;
    private String code;
    private String dutyName;

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
}
