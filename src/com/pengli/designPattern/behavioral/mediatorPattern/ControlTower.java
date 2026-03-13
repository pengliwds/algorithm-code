package com.pengli.designPattern.behavioral.mediatorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体中介者 - 塔台控制中心
 */
public class ControlTower implements AirportMediator {
    private List<Plane> planes;
    private String weatherStatus;

    public ControlTower() {
        this.planes = new ArrayList<>();
        this.weatherStatus = "晴朗";
    }

    @Override
    public void registerPlane(Plane plane) {
        planes.add(plane);
        System.out.println("[塔台] 飞机 " + plane.getFlightNumber() + " 已注册到机场调度系统");
    }

    @Override
    public void sendDispatch(String message, Plane sender) {
        System.out.println("[塔台] 调度信息来自飞机 " + sender.getFlightNumber() + ": " + message);
        // 塔台可以处理调度信息
        if (message.contains("请求") && message.contains("航线")) {
            System.out.println("[塔台] 正在处理航线规划...");
            sender.receiveResponse("航线规划已确认");
        }
    }

    @Override
    public void sendTakeoffPermission(String flightNumber) {
        for (Plane plane : planes) {
            if (plane.getFlightNumber().equals(flightNumber)) {
                plane.receiveTakeoffPermission();
                break;
            }
        }
    }

    @Override
    public void sendLandingPermission(String flightNumber) {
        for (Plane plane : planes) {
            if (plane.getFlightNumber().equals(flightNumber)) {
                plane.receiveLandingPermission();
                break;
            }
        }
    }

    @Override
    public void broadcastEmergency(String message) {
        System.out.println("[紧急] 塔台广播: " + message);
        for (Plane plane : planes) {
            plane.receiveEmergencyAlert(message);
        }
    }

    @Override
    public String getWeatherStatus() {
        return weatherStatus;
    }

    public void updateWeatherStatus(String status) {
        this.weatherStatus = status;
        System.out.println("[塔台] 天气更新: " + status);
    }

    public List<Plane> getPlanes() {
        return new ArrayList<>(planes);
    }
}