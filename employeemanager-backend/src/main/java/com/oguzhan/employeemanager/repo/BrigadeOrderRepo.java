package com.oguzhan.employeemanager.repo;

import com.oguzhan.employeemanager.model.BrigadeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrigadeOrderRepo   extends JpaRepository<BrigadeOrder, Long> {
}
