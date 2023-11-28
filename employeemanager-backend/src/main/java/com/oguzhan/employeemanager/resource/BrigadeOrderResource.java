package com.oguzhan.employeemanager.resource;

import com.oguzhan.employeemanager.model.BrigadeOrder;
import com.oguzhan.employeemanager.service.BrigadeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brigadeOrder")
public class BrigadeOrderResource {
    private final BrigadeOrderService brigadeOrderService;
    @Autowired
    public BrigadeOrderResource(BrigadeOrderService brigadeOrderService) {
        this.brigadeOrderService = brigadeOrderService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BrigadeOrder>> getAllBrigadeOrders(){
        List<BrigadeOrder> brigadeOrders= brigadeOrderService.findAllBrigadeOrders();
        return new ResponseEntity<>(brigadeOrders, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<BrigadeOrder> updateBrigadeOrder(@RequestBody BrigadeOrder brigadeOrder){
        BrigadeOrder updatedBrigadeOrder= brigadeOrderService.updateBrigadeOrder(brigadeOrder);
        return new ResponseEntity<>(updatedBrigadeOrder, HttpStatus.OK);
    }
}
