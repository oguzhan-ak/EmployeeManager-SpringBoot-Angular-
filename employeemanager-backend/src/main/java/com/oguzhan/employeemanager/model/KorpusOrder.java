package com.oguzhan.employeemanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "KorpusOrder")
@Table(name = "korpus_order")
public class KorpusOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name="tmk_id",referencedColumnName="id",nullable=false)
    @JsonBackReference
    private Tmk tmk;

    @ManyToOne
    @JoinColumn(name="korpus_id",referencedColumnName="id",nullable=false)
    @JsonBackReference
    private Korpus korpus;

    public KorpusOrder() {
    }

    public void setTmk(Tmk tmk) {
        this.tmk = tmk;
    }

    public Korpus getKorpus() {
        return korpus;
    }

    public void setKorpus(Korpus korpus) {
        this.korpus = korpus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Tmk getTmk() {
        return tmk;
    }

    @Override
    public String toString() {
        return "KorpusOrder{" +
                "id=" + id +
                '}';
    }
}
