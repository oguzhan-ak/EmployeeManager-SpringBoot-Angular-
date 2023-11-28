package com.oguzhan.employeemanager.repo;

import com.oguzhan.employeemanager.model.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarTypeRepo  extends JpaRepository<CarType, Long> {
    void deleteCarTypeById(Long id);
    void deleteCarTypeByIdIn(List<Long> ids);

    Optional<CarType> findCarTypeById(Long id);
}
