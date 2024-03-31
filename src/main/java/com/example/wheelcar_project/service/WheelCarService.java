package com.example.wheelcar_project.service;

import com.example.wheelcar_project.dto.request.WheelCarRequest;
import com.example.wheelcar_project.dto.response.WheelCarResponse;
import com.example.wheelcar_project.entity.WheelCarEntity;

import java.util.List;

public interface WheelCarService {

    WheelCarResponse addCar(WheelCarRequest carDTO);

    public List<WheelCarEntity> getCarsByWheelNo(String wheelNO);
    public List<WheelCarEntity> getAll();
}
