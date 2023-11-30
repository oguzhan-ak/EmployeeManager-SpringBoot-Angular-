package com.oguzhan.employeemanager.repo;

import com.oguzhan.employeemanager.model.BrigadeOrder;
import com.oguzhan.employeemanager.model.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RankRepo    extends JpaRepository<Rank, Long> {
    public List<Rank> findAllByBrigadeOrderId(Long brigadeOrderId);
}
