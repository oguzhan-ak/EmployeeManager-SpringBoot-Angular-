package com.oguzhan.employeemanager.resource;

import com.oguzhan.employeemanager.dto.BrigadeOrderDTO;
import com.oguzhan.employeemanager.dto.KorpusOrderDTO;
import com.oguzhan.employeemanager.service.KorpusOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/korpusOrder")
public class KorpusOrderResource {
    private final KorpusOrderService korpusOrderService;

    @Autowired
    public KorpusOrderResource(KorpusOrderService korpusOrderService) {
        this.korpusOrderService = korpusOrderService;
    }

    @GetMapping("/all/{korpusId}")
    public ResponseEntity<List<KorpusOrderDTO>> getAllKorpusOrders(@PathVariable Long korpusId){
        List<KorpusOrderDTO> korpusOrders= korpusOrderService.findAllKorpusOrdersByKorpusId(korpusId);
        return new ResponseEntity<>(korpusOrders, HttpStatus.OK);
    }

//    @PutMapping("/update")
//    public ResponseEntity<BrigadeOrderDTO> updateBrigadeOrder(@RequestBody KorpusOrderDTO korpusOrder){
//        BrigadeOrderDTO updatedBrigadeOrder= brigadeOrderService.updateBrigadeOrder(brigadeOrder);
//        return new ResponseEntity<>(updatedBrigadeOrder, HttpStatus.OK);
//    }
}
