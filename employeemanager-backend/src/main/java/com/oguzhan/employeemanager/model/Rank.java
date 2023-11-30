package com.oguzhan.employeemanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.oguzhan.employeemanager.enums.RankType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Rank")
@Table(name = "rank")
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RankType rankType;
    private Long amount;
    @ManyToOne(fetch = FetchType.EAGER)
    private BrigadeOrder brigadeOrder;

    public BrigadeOrder getBrigadeOrder() {
        return brigadeOrder;
    }

    public void setBrigadeOrder(BrigadeOrder brigadeOrder) {
        this.brigadeOrder = brigadeOrder;
    }

    public Rank(RankType rankType, Long amount) {
        this.rankType = rankType;
        this.amount = amount;
    }

    public Rank() {
    }


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

    @Override
    public String toString() {
        return "Rank{" +
                "id=" + id +
                ", rankType=" + rankType +
                ", amount=" + amount +
                '}';
    }
}