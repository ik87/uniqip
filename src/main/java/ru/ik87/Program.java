package ru.ik87;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Duration;
import java.time.Instant;

/**
 * @author Kosolapov Ilya (d_dexter@mail.ru)
 * @version 1.0
 * @since 21.11.2020
 */
public class Program {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("please attache file");
            return;
        }
        String strCurrentLine;
        long total = 0;
        BankIP bankIP = new BankIP();
        System.out.println("Start processing. Wait...");
        Instant start = Instant.now();
        try (BufferedReader objReader =
                     new BufferedReader(new FileReader(args[0]))) {
            while ((strCurrentLine = objReader.readLine()) != null) {
                bankIP.addIP(strCurrentLine);
                total++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        Instant stop = Instant.now();
        System.out.println("finish");
        System.out.printf("total ip: %s\n", total);
        System.out.printf("unique ip: %s\n", bankIP);
        Duration d = Duration.between(start, stop);
        long minutesPart = d.toMinutes();
        long secondsPart = d.minusMinutes(minutesPart).getSeconds();
        System.out.printf("elapsed time:  %s M  %s S", minutesPart, secondsPart);
    }
}
