package com.oguzhan.employeemanager.model;

import jakarta.persistence.*;

@Entity(name = "Brigade")
@Table(name = "brigade")
public class Brigade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="korpus_id",referencedColumnName="id",nullable=false)
    private Korpus korpus;

    public Brigade() {
    }

    public Brigade(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brigade{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
