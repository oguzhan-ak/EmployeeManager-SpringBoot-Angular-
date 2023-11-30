package com.oguzhan.employeemanager.repo;

import com.oguzhan.employeemanager.model.BrigadeOrder;
import com.oguzhan.employeemanager.model.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BrigadeOrderRepo extends JpaRepository<BrigadeOrder, Long> {
    public List<BrigadeOrder> findAllBrigadeOrdersByBrigadeIdAndKorpusOrderId(Long brigadeId, Long korpusOrderId);
    public List<BrigadeOrder> findAllBrigadeOrdersByKorpusOrderId(Long korpusOrderId);

}
