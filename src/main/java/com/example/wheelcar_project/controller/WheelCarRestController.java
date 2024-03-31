package com.example.wheelcar_project.controller;


import com.example.wheelcar_project.dto.request.WheelCarRequest;
import com.example.wheelcar_project.dto.response.WheelCarResponse;
import com.example.wheelcar_project.entity.WheelCarEntity;
import com.example.wheelcar_project.service.WheelCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class WheelCarRestController {

    @Autowired
    private WheelCarService wheelCarService;


    @PostMapping("/insert")
    public ResponseEntity<WheelCarResponse> addCar(@RequestBody WheelCarRequest request) {
        WheelCarResponse response = wheelCarService.addCar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/getCarsByWheelNo")
    public ResponseEntity<List<WheelCarEntity>> getCarsByWheelNo(@RequestParam("wheelNo") String wheelNo) {
        List<WheelCarEntity> matchingCars = wheelCarService.getCarsByWheelNo(wheelNo);
        return ResponseEntity.ok(matchingCars);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<WheelCarEntity>> getCarsByWheelNo() {
        List<WheelCarEntity> matchingCars = wheelCarService.getAll();
        return ResponseEntity.ok(matchingCars);
    }

}
