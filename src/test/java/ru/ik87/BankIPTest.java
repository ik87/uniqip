package ru.ik87;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankIPTest {
    @Test
    public void whenOneNotRepeatThenOne() {
        String ip = "192.168.3.3 192.168.3.2 192.168.3.3";
        BankIP bank = new BankIP();
        Arrays.stream(ip.split(" ")).forEach(bank::addIP);
        assertThat(bank.toString(), is("2"));
    }


    @Test
    public void whenTwoNotRepeatThenTwo() {
        String ip = "192.168.3.3 192.168.3.2 192.168.3.3 192.168.3.1";
        BankIP bank = new BankIP();
        Arrays.stream(ip.split(" ")).forEach(bank::addIP);
        assertThat(bank.toString(), is("3"));
    }

    @Test
    public void whenEveryHasRepeatThenZero() {
        String ip = "192.168.3.3 192.168.3.2 192.168.3.3 192.168.3.2";
        BankIP bank = new BankIP();
        Arrays.stream(ip.split(" ")).forEach(bank::addIP);
        assertThat(bank.toString(), is("2"));
    }

    @Test
    public void whenEveryHasRepeatTwiceOrMoreThenZero() {
        String ip = "192.168.3.3 192.168.3.2 192.168.3.3 192.168.3.2 192.168.3.3";
        BankIP bank = new BankIP();
        Arrays.stream(ip.split(" ")).forEach(bank::addIP);
        assertThat(bank.toString(), is("2"));
    }

    @Test
    public void checkMistake() {
        String ip = "192.0.0.0 0.168.0.0 0.0.3.0 0.0.0.2 192.168.3.2";
        BankIP bank = new BankIP();
        Arrays.stream(ip.split(" ")).forEach(bank::addIP);
        assertThat(bank.toString(), is("5"));
    }
    @Test
    public void checkMax() {
        String ip = "0.0.0.0 0.0.0.0 0.0.0.1 255.255.255.255";
        BankIP bank = new BankIP();
        Arrays.stream(ip.split(" ")).forEach(bank::addIP);
        assertThat(bank.toString(), is("3"));
    }
}