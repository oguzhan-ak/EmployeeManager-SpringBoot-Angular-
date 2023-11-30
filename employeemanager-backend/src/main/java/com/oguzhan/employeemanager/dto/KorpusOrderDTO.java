package com.oguzhan.employeemanager.dto;

import com.oguzhan.employeemanager.model.BrigadeOrder;

import java.util.ArrayList;
import java.util.List;

public class KorpusOrderDTO {
    private Long id;
    private KorpusDTO korpus;
    private TmkDTO tmk;
    private List<BrigadeOrderDTO> brigadeOrders = new ArrayList<>();

    public KorpusOrderDTO(Long id, KorpusDTO korpus, TmkDTO tmk) {
        this.id = id;
        this.korpus = korpus;
        this.tmk = tmk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KorpusDTO getKorpus() {
        return korpus;
    }

    public void setKorpus(KorpusDTO korpus) {
        this.korpus = korpus;
    }

    public TmkDTO getTmk() {
        return tmk;
    }

    public void setTmk(TmkDTO tmk) {
        this.tmk = tmk;
    }

    public List<BrigadeOrderDTO> getBrigadeOrders() {
        return brigadeOrders;
    }

    public void setBrigadeOrders(List<BrigadeOrderDTO> brigadeOrders) {
        this.brigadeOrders = brigadeOrders;
    }
}
