package com.oguzhan.employeemanager.model;

import jakarta.persistence.*;

@Entity
public class BirigadeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String hui;
    private String code;
    private String dutyName;
    private List<>
}
