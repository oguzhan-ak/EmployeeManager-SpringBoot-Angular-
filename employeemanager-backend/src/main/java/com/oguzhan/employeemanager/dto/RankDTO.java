package com.oguzhan.employeemanager.dto;

import com.oguzhan.employeemanager.enums.RankType;

public class RankDTO {
    private Long id;
    private RankType rankType;
    private Long amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RankType getRankType() {
        return rankType;
    }

    public void setRankType(RankType rankType) {
        this.rankType = rankType;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
