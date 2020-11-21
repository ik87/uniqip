package ru.ik87;

import java.util.Arrays;

/**
 * @author Kosolapov Ilya (d_dexter@mail.ru)
 * @version 1.0
 * @since 21.11.2020
 */
public class BankIP {
    long count = 0;
    final boolean[][] ip = new boolean[4][256];

    public void addIP(String strIP) {
        int[] arrIP = parseIp(strIP);
        if (!checkIp(arrIP)) {
            addIP(arrIP);
            count++;
        }
    }

    private boolean checkIp(int[] arrIP) {
        return ip[0][arrIP[0]]
                & ip[1][arrIP[1]]
                & ip[2][arrIP[2]]
                & ip[3][arrIP[3]];
    }

    private int[] parseIp(String strIP) {
        return Arrays.stream(strIP.split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    private void addIP(int[] arrIP) {
        ip[0][arrIP[0]] = true;
        ip[1][arrIP[1]] = true;
        ip[2][arrIP[2]] = true;
        ip[3][arrIP[3]] = true;
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
