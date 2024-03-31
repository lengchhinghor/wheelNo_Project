package com.example.wheelcar_project.service.imp;

import com.example.wheelcar_project.dto.request.WheelCarRequest;
import com.example.wheelcar_project.dto.response.WheelCarResponse;
import com.example.wheelcar_project.entity.WheelCarEntity;
import com.example.wheelcar_project.repository.WheelCarRepository;
import com.example.wheelcar_project.service.WheelCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WheelCarServiceImp implements WheelCarService {


    @Autowired
    private final WheelCarRepository wheelCarRepository;

    public WheelCarServiceImp(WheelCarRepository wheelCarRepository) {
        this.wheelCarRepository = wheelCarRepository;
    }

    @Override
    public WheelCarResponse addCar(WheelCarRequest request) {
        String carName = request.getCarName();
        WheelCarEntity existingCar = wheelCarRepository.findByCarName(carName);

        if (existingCar == null) {

            if (request.getWheelNo() == null) {
                WheelCarResponse wheelCarResponse = new WheelCarResponse();
                wheelCarResponse.setCarName(carName);
                wheelCarResponse.setWheelNo(null);
                wheelCarResponse.setMessageResponse(carName + " is not on my list. Number of wheels?");
                return wheelCarResponse;

            } else {

                WheelCarEntity newCar = new WheelCarEntity();

                newCar.setCarName(carName);
                newCar.setWheelNo(request.getWheelNo());

                wheelCarRepository.save(newCar);

                WheelCarResponse wheelCarResponse = new WheelCarResponse();
                wheelCarResponse.setCarName(carName);
                wheelCarResponse.setWheelNo(request.getWheelNo());
                wheelCarResponse.setMessageResponse("Thanks. I updated the information.");

                return wheelCarResponse;
            }

        } else {

            String wheelNo = existingCar.getWheelNo();

            WheelCarResponse wheelCarResponse = new WheelCarResponse();

            wheelCarResponse.setCarName(carName);
            wheelCarResponse.setWheelNo(wheelNo);
            wheelCarResponse.setMessageResponse(carName + " has " + wheelNo+ " wheels");

            return wheelCarResponse;
        }
    }

    @Override
    public List<WheelCarEntity> getCarsByWheelNo(String wheelNo) {
        List<WheelCarEntity> matchingCars = wheelCarRepository.findByWheelNo(wheelNo);
        if (matchingCars == null) {
            // Handle null response here, such as returning an empty list or throwing an exception
            return Collections.emptyList(); // Return an empty list
        }
        return matchingCars;
    }

    @Override
    public List<WheelCarEntity> getAll() {
        List<WheelCarEntity> matchingCars = wheelCarRepository.findAll();
        if (matchingCars == null) {
            // Handle null response here, such as returning an empty list or throwing an exception
            return Collections.emptyList(); // Return an empty list
        }
        return matchingCars;
    }
}
