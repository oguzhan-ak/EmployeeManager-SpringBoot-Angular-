package com.oguzhan.employeemanager.dto;

import java.util.ArrayList;
import java.util.List;

public class BrigadeOrderDTO {
    private Long id;
    private BrigadeDTO brigade;
    private TmkDTO tmk;
    private List<RankDTO> brigadeRanks = new ArrayList<>();

    public BrigadeOrderDTO(Long id, BrigadeDTO brigade, TmkDTO tmk) {
        this.id = id;
        this.brigade = brigade;
        this.tmk = tmk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BrigadeDTO getBrigade() {
        return brigade;
    }

    public void setBrigade(BrigadeDTO brigade) {
        this.brigade = brigade;
    }

    public TmkDTO getTmk() {
        return tmk;
    }

    public void setTmk(TmkDTO tmk) {
        this.tmk = tmk;
    }

    public List<RankDTO> getBrigadeRanks() {
        return brigadeRanks;
    }

    public void setBrigadeRanks(List<RankDTO> brigadeRanks) {
        this.brigadeRanks = brigadeRanks;
    }
}
