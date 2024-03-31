package com.example.wheelcar_project.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WheelCarResponse {

    private Integer id;
    private String carName;
    private String wheelNo;
    private String messageResponse;
}
