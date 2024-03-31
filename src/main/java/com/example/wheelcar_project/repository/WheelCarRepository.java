package com.example.wheelcar_project.repository;

import com.example.wheelcar_project.entity.WheelCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WheelCarRepository extends JpaRepository<WheelCarEntity, Integer> {

    WheelCarEntity findByCarName(String carName);

    List<WheelCarEntity> findByWheelNo(String wheelNo);

}