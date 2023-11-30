package com.oguzhan.employeemanager.model;

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
    @ManyToOne
    @JoinColumn(name="brigade_id",referencedColumnName="id",nullable=false)
    private Brigade brigade;
    @ManyToOne
    @JoinColumn(name="tmk_id",referencedColumnName="id",nullable=false)
    private Tmk tmk;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="korpus_order_id",referencedColumnName="id",nullable=false)
    private KorpusOrder korpusOrder;

    public BrigadeOrder() {
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }

    public void setTmk(Tmk tmk) {
        this.tmk = tmk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brigade getBrigade() {
        return brigade;
    }

    public Tmk getTmk() {
        return tmk;
    }


    @Override
    public String toString() {
        return "BrigadeOrder{" +
                "id=" + id +
                '}';
    }
}
