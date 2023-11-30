package com.oguzhan.employeemanager.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Korpus")
@Table(name = "korpus")
public class Korpus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;

    public Korpus(String name) {
        this.name = name;
    }

    public Korpus() {
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
        return "Korpus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
