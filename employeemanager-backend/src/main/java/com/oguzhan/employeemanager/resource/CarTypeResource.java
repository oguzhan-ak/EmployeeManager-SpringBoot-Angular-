package com.oguzhan.employeemanager.resource;

import com.oguzhan.employeemanager.model.CarType;
import com.oguzhan.employeemanager.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carType")
public class CarTypeResource {
    private final CarTypeService carTypeService;
    @Autowired
    public CarTypeResource(CarTypeService carTypeService) {
        this.carTypeService = carTypeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarType>> getAllCarTypes(){
        List<CarType> carTypes= carTypeService.findAllCarTypes();
        return new ResponseEntity<>(carTypes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CarType> getCarTypeById(@PathVariable("id") Long id){
        CarType carType= carTypeService.findCarTypeById(id);
        return new ResponseEntity<>(carType, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CarType> addCarType(@RequestBody CarType carType){
        CarType newCarType= carTypeService.addCarType(carType);
        return new ResponseEntity<>(newCarType, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CarType> updateCarType(@RequestBody CarType carType){
        CarType updatedCarType = carTypeService.updateCarType(carType);
        return new ResponseEntity<>(updatedCarType, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCarType(@PathVariable Long id){
        carTypeService.deleteCarType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteMultiple")
    public ResponseEntity<?> deleteCarType(@RequestBody List<Long> idList){
        carTypeService.deleteCarTypes(idList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
