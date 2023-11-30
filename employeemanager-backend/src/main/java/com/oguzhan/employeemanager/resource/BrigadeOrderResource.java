package com.oguzhan.employeemanager.resource;

import com.oguzhan.employeemanager.dto.BrigadeOrderDTO;
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

    @GetMapping("/all/{brigadeId}/{korpusOrderId}")
    public ResponseEntity<List<BrigadeOrderDTO>> getAllBrigadeOrders(@PathVariable Long brigadeId,@PathVariable Long korpusOrderId){
        List<BrigadeOrderDTO> brigadeOrders= brigadeOrderService.findAllBrigadeOrdersByBrigadeIdAndKorpusOrderId(brigadeId, korpusOrderId);
        return new ResponseEntity<>(brigadeOrders, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<BrigadeOrderDTO> updateBrigadeOrder(@RequestBody BrigadeOrderDTO brigadeOrder){
        BrigadeOrderDTO updatedBrigadeOrder= brigadeOrderService.updateBrigadeOrder(brigadeOrder);
        return new ResponseEntity<>(updatedBrigadeOrder, HttpStatus.OK);
    }
}
