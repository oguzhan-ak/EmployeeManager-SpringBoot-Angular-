package com.oguzhan.employeemanager.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "BrigadeOrder")
@Table(name = "brigade_order")
public class BrigadeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String hui;
    private String code;
    private String dutyName;
    @OneToMany(mappedBy = "brigadeOrder", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("rankType")
    private List<Rank> ranks = new ArrayList<>();

    public BrigadeOrder() {
    }

    public void addRank(Rank rank) {
        ranks.add(rank);
        rank.setBrigadeOrder(this);
    }

    public void removeComment(Rank rank) {
        ranks.remove(rank);
        rank.setBrigadeOrder(null);
    }

    public BrigadeOrder(String hui, String code, String dutyName, List<Rank> ranks) {
        this.hui = hui;
        this.code = code;
        this.dutyName = dutyName;
        this.ranks = ranks;
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

    @JsonManagedReference
    public List<Rank> getRanks() {
        return ranks;
    }

    public void setRanks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    @Override
    public String toString() {
        return "BrigadeOrder{" +
                "id=" + id +
                ", hui='" + hui + '\'' +
                ", code='" + code + '\'' +
                ", dutyName='" + dutyName + '\'' +
                ", ranks=" + ranks +
                '}';
    }
}
