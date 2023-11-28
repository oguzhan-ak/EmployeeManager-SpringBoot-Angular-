package com.oguzhan.employeemanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.oguzhan.employeemanager.enums.RankType;
import jakarta.persistence.*;

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
    @ManyToOne
    @JoinColumn(name="brigade_order_id",referencedColumnName="id",nullable=false)
    private BrigadeOrder brigadeOrder;

    public Rank(RankType rankType, Long amount) {
        this.rankType = rankType;
        this.amount = amount;
    }

    @JsonBackReference
    public BrigadeOrder getBrigadeOrder() {
        return brigadeOrder;
    }

    public void setBrigadeOrder(BrigadeOrder brigadeOrder) {
        this.brigadeOrder = brigadeOrder;
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