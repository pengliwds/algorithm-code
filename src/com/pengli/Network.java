package com.pengli;


public class Network {
    /**
     * 判断ip是否在网段内
     * 将IP地址转换为数字，和子网掩码做与运算，如果和网络地址和子网掩码做与运算结果一样，代表在同一网段内
     *
     * @param ip   IP地址，如 192.168.0.12
     * @param cidr 给定的网段 如 192.168.0.0/24
     * @return IP地址是否在给定的网段内
     */
    public static boolean isRange(String ip, String cidr) {

        if (!cidr.contains("/")) {
            return ip.equals(cidr);
        } else {
            String[] ips = ip.split("\\.");
            // ip地址的十进制值
            int ipAddress = (Integer.parseInt(ips[0]) << 24) | (Integer.parseInt(ips[1]) << 16) | (Integer.parseInt(ips[2]) << 8) | (Integer.parseInt(ips[3]));
            // 获取掩码
            int type = Integer.parseInt(cidr.replaceAll(".*/", ""));
            int mask = 0xFFFFFFFF << (32 - type);
            // 获取网络地址
            String cidrIP = cidr.replaceAll("/.*", "");
            String[] cidrIPs = cidrIP.split("\\.");
            int cidrAddress = (Integer.parseInt(cidrIPs[0]) << 24) | (Integer.parseInt(cidrIPs[1]) << 16) | (Integer.parseInt(cidrIPs[2]) << 8) | (Integer.parseInt(cidrIPs[3]));
            return (ipAddress & mask) == (cidrAddress & mask);
        }
    }

    public static void main(String[] args) {
        System.out.println(isRange("192.168.0.123", "192.168.0.0/24"));
    }
}
