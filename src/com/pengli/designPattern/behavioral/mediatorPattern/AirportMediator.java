package com.pengli.designPattern.behavioral.mediatorPattern;

/**
 * 中介者接口 - 机场调度中介者
 */
public interface AirportMediator {
    // 注册飞机
    void registerPlane(Plane plane);

    // 发送调度信息
    void sendDispatch(String message, Plane sender);

    // 发送起飞许可
    void sendTakeoffPermission(String flightNumber);

    // 发送降落许可
    void sendLandingPermission(String flightNumber);

    // 广播紧急信息
    void broadcastEmergency(String message);

    // 获取天气信息
    String getWeatherStatus();
}