package ru.ik87;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankIPTest {

    @Test
    public void whenCheckFileThenGet() {
        String ip = "192.168.3.3 192.168.3.2 192.168.3.3";
        BankIP bankIP = new BankIP();
        Arrays.stream(ip.split(" ")).forEach(bankIP::addIP);
        assertThat(bankIP.toString(), is("2"));
    }

}