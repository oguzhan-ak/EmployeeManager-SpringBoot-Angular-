package com.oguzhan.employeemanager.service;

import com.oguzhan.employeemanager.model.BrigadeOrder;
import com.oguzhan.employeemanager.model.CarType;
import com.oguzhan.employeemanager.repo.BrigadeOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrigadeOrderService {
    private final BrigadeOrderRepo brigadeOrderRepo;

    @Autowired
    public BrigadeOrderService(BrigadeOrderRepo brigadeOrderRepo) {
        this.brigadeOrderRepo = brigadeOrderRepo;
    }

    public List<BrigadeOrder> findAllBrigadeOrders(){
        return  brigadeOrderRepo.findAll();
    }

    public BrigadeOrder updateBrigadeOrder(BrigadeOrder brigadeOrder){
        return brigadeOrderRepo.save(brigadeOrder);
    }
}
