package com.oguzhan.employeemanager.repo;

import com.oguzhan.employeemanager.model.BrigadeOrder;
import com.oguzhan.employeemanager.model.KorpusOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KorpusOrderRepo extends JpaRepository<KorpusOrder, Long> {
    public List<KorpusOrder> findAllKorpusOrdersByKorpusId(Long korpusOrderId);
}
