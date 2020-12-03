package ru.ik87;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankIPTest {

    @Test
    public void whenOneNotRepeatThenOne() {
        String ip = "192.168.3.3 192.168.3.2 192.168.3.3";
        BankIP bankIP = new BankIP();
        Arrays.stream(ip.split(" ")).forEach(bankIP::addIP);
        assertThat(bankIP.toString(), is("1"));
    }

    @Test
    public void whenTwoNotRepeatThenTwo() {
        String ip = "192.168.3.3 192.168.3.2 192.168.3.3 192.168.3.1";
        BankIP bankIP = new BankIP();
        Arrays.stream(ip.split(" ")).forEach(bankIP::addIP);
        assertThat(bankIP.toString(), is("2"));
    }

    @Test
    public void whenEveryHasRepeatThenZero() {
        String ip = "192.168.3.3 192.168.3.2 192.168.3.3 192.168.3.2";
        BankIP bankIP = new BankIP();
        Arrays.stream(ip.split(" ")).forEach(bankIP::addIP);
        assertThat(bankIP.toString(), is("0"));
    }

    @Test
    public void whenEveryHasRepeatTwiceOrMoreThenZero() {
        String ip = "192.168.3.3 192.168.3.2 192.168.3.3 192.168.3.2 192.168.3.3";
        BankIP bankIP = new BankIP();
        Arrays.stream(ip.split(" ")).forEach(bankIP::addIP);
        assertThat(bankIP.toString(), is("0"));
    }
}