package ru.ik87;

import java.util.Arrays;

/**
 * @author Kosolapov Ilya (d_dexter@mail.ru)
 * @version 2.0
 * @since 04.12.2020
 */
public class BankIP {
    private static final int SIZE = 67108864;
    private long count = 0;
    long[] ips = new long[SIZE];

    public BankIP() {
    }

    public void addIP(String strIP) {
        long ip = ipToLong(strIP);
        if (checkIp(ip)) {
            addIp(ip);
            count++;
        }

    }

    private long ipToLong(String strIp) {
        long[] ip = Arrays.stream(strIp.split("\\."))
                .mapToLong(Long::parseLong)
                .toArray();
        ip[0] *= 16777216;
        ip[1] *= 65536;
        ip[2] *= 256;
        return ip[0] + ip[1] + ip[2] + ip[3];
    }

    private boolean checkIp(long ip) {
       // System.out.printf("%s / %s y:%s x:%s\n",ip, 64,  ip / 64, 1L << (ip % 64));
        return (ips[(int) (ip / 64)] & (1L << (ip % 64))) == 0;
    }

    private void addIp(long ip) {
        ips[(int) (ip / 64)] |= 1L << (ip % 64);
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
