package com.example.drones;

public class BaseResponse {

    public static final String SUCCESS_STATUS = "Success";
    public static final String ERROR_STATUS = "Error";
    public static final String ERROR_DRONE_NOT_READY = "Drone is not ready";
    public static final String ERROR_DRONE_NOT_CHARGED = "Drone is not charged up to 25%";
    public static final String ERROR_DRONE_FULL = "Drone is full or have no free weight limit";
    public static final String UNKNOWN_DATA_STATUS = "unknown data";
    public static final int CODE_SUCCESS = 100;
    public static final int CODE_ERROR_DATA = 101;

    private final String status;
    private final Integer code;

    public BaseResponse(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }
}
