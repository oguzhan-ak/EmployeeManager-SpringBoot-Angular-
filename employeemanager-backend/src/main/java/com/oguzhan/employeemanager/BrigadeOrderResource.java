package com.oguzhan.employeemanager;

import com.oguzhan.employeemanager.model.BrigadeOrder;
import com.oguzhan.employeemanager.model.CarType;
import com.oguzhan.employeemanager.service.BrigadeOrderService;
import com.oguzhan.employeemanager.service.CarTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brigadeOrder")
public class BrigadeOrderResource {
    private final BrigadeOrderService brigadeOrderService;

    public BrigadeOrderResource(BrigadeOrderService brigadeOrderService) {
        this.brigadeOrderService = brigadeOrderService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BrigadeOrder>> getAllBrigadeOrders(){
        List<BrigadeOrder> brigadeOrders= brigadeOrderService.findAllBrigadeOrders();
        return new ResponseEntity<>(brigadeOrders, HttpStatus.OK);
    }
}
