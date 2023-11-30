package com.oguzhan.employeemanager.dto;

import java.util.ArrayList;
import java.util.List;

public class KorpusDTO {
    private Long id;
    private String name;
    private List<BrigadeDTO> brigades = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BrigadeDTO> getBrigades() {
        return brigades;
    }

    public void setBrigades(List<BrigadeDTO> brigades) {
        this.brigades = brigades;
    }
}
