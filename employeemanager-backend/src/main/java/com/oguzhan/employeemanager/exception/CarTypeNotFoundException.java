package com.oguzhan.employeemanager.exception;

public class CarTypeNotFoundException  extends  RuntimeException{
    public CarTypeNotFoundException(String message) {
        super(message);
    }
}
