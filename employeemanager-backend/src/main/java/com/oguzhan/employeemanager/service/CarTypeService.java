package com.oguzhan.employeemanager.service;

import com.oguzhan.employeemanager.exception.CarTypeNotFoundException;
import com.oguzhan.employeemanager.model.CarType;
import com.oguzhan.employeemanager.repo.CarTypeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CarTypeService {
    private final CarTypeRepo carTypeRepo;

    @Autowired
    public CarTypeService(CarTypeRepo carTypeRepo) {
        this.carTypeRepo = carTypeRepo;
    }

    public CarType addCarType(CarType carType){
        return carTypeRepo.save(carType);
    }

    public List<CarType> findAllCarTypes(){
        return carTypeRepo.findAll();
    }

    public CarType updateCarType(CarType carType){
        return carTypeRepo.save(carType);
    }

    public CarType findCarTypeById(Long id){

        return carTypeRepo.findCarTypeById(id).orElseThrow(
                () -> new CarTypeNotFoundException("Car Type by id "+ id+ " was not found")
        );
    }


    public void deleteCarType(Long id){
        carTypeRepo.deleteCarTypeById(id);
    }

    public void deleteCarTypes(List<Long> idList){
        carTypeRepo.deleteCarTypeByIdIn(idList);
    }
}
