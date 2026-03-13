package com.pengli.designPattern.behavioral.mediatorPattern;

/**
 * 同事类 - 飞机
 */
public class Plane {
    private String flightNumber;  // 航班号
    private String status;       // 状态：空中、起飞中、降落中、地面
    private int altitude;       // 飞行高度
    private AirportMediator mediator;

    public Plane(String flightNumber, AirportMediator mediator) {
        this.flightNumber = flightNumber;
        this.mediator = mediator;
        this.status = "地面";
        this.altitude = 0;
        this.mediator.registerPlane(this);
    }

    // 请求起飞
    public void requestTakeoff() {
        System.out.println("[飞机 " + flightNumber + "] 请求起飞");
        if (mediator.getWeatherStatus().equals("雷雨")) {
            System.out.println("[飞机 " + flightNumber + "] 由于天气原因，起飞请求被拒绝");
            return;
        }
        status = "准备起飞";
        mediator.sendTakeoffPermission(flightNumber);
    }

    // 请求降落
    public void requestLanding() {
        System.out.println("[飞机 " + flightNumber + "] 请求降落，当前高度：" + altitude + "米");
        status = "准备降落";
        mediator.sendLandingPermission(flightNumber);
    }

    // 发送调度信息
    public void sendDispatchMessage(String message) {
        System.out.println("[飞机 " + flightNumber + "] 发送调度信息");
        mediator.sendDispatch(message, this);
    }

    // 接收起飞许可
    public void receiveTakeoffPermission() {
        if (status.equals("准备起飞")) {
            status = "起飞中";
            altitude = 1000;
            System.out.println("[飞机 " + flightNumber + "] 收到起飞许可，开始起飞，爬升至 " + altitude + "米");

            // 模拟爬升过程
            new Thread(() -> {
                for (int i = 1000; i <= 10000; i += 1000) {
                    try {
                        Thread.sleep(500);
                        altitude = i;
                        System.out.println("[飞机 " + flightNumber + "] 爬升至 " + altitude + "米");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                status = "空中";
                System.out.println("[飞机 " + flightNumber + "] 已到达巡航高度 " + altitude + "米，进入巡航状态");
            }).start();
        }
    }

    // 接收降落许可
    public void receiveLandingPermission() {
        if (status.equals("准备降落")) {
            status = "降落中";

            // 模拟降落过程
            new Thread(() -> {
                for (int i = altitude; i >= 0; i -= 500) {
                    try {
                        Thread.sleep(300);
                        altitude = i;
                        System.out.println("[飞机 " + flightNumber + "] 下降至 " + altitude + "米");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                altitude = 0;
                status = "地面";
                System.out.println("[飞机 " + flightNumber + "] 降落完成，已停机");
            }).start();
        }
    }

    // 接收响应
    public void receiveResponse(String response) {
        System.out.println("[飞机 " + flightNumber + "] 收到响应: " + response);
    }

    // 接收紧急警报
    public void receiveEmergencyAlert(String message) {
        System.out.println("[飞机 " + flightNumber + "] 收到紧急警报: " + message);
        // 飞机收到紧急警报后的反应
        if (status.equals("空中") && altitude < 3000) {
            System.out.println("[飞机 " + flightNumber + "] 立即爬升至安全高度");
            altitude = 3000;
        }
    }

    // 获取航班号
    public String getFlightNumber() {
        return flightNumber;
    }

    // 获取状态
    public String getStatus() {
        return status;
    }

    // 设置状态（用于测试场景）
    public void setStatus(String status) {
        this.status = status;
    }

    // 获取高度
    public int getAltitude() {
        return altitude;
    }

    // 设置高度（用于测试场景）
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return String.format("飞机[航班号=%s, 状态=%s, 高度=%d米]", flightNumber, status, altitude);
    }
}