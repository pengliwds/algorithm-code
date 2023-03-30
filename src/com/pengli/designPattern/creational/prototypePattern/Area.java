package com.pengli.designPattern.creational.prototypePattern;

/**
 * @Author pengli
 * @Date 27/3/2023
 * @Version 1.0
 */
public class Area implements Cloneable{

    private String province;

    private String city;

    @Override
    protected Area clone() throws CloneNotSupportedException {
        return (Area)super.clone();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Area{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
