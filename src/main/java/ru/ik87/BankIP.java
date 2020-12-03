package ru.ik87;

import java.util.Arrays;

/**
 * @author Kosolapov Ilya (d_dexter@mail.ru)
 * @version 1.1
 * @since 21.11.2020
 */
public class BankIP {
    long count = 0;
    final boolean[][][] ip = new boolean[2][4][256];

    public void addIP(String strIP) {
        int[] arrIP = parseIp(strIP);

        if (!checkIp(arrIP, 0)) {
            addIP(arrIP, 0);
            count++;
        } else if (!checkIp(arrIP, 1)) {
            addIP(arrIP, 1);
            count--;
        }

    }

    //if 1 & 1 & 1 & 1 = then exist
    private boolean checkIp(int[] arrIP, int cell) {
        return ip[cell][0][arrIP[0]]
                & ip[cell][1][arrIP[1]]
                & ip[cell][2][arrIP[2]]
                & ip[cell][3][arrIP[3]];
    }

    private int[] parseIp(String strIP) {
        return Arrays.stream(strIP.split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    private void addIP(int[] arrIP, int cell) {
        ip[cell][0][arrIP[0]] = true;
        ip[cell][1][arrIP[1]] = true;
        ip[cell][2][arrIP[2]] = true;
        ip[cell][3][arrIP[3]] = true;
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
