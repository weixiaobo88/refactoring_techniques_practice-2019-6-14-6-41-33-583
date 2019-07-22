package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printOwing() {
        OwingPrinter owingPrinter = new OwingPrinter();
        Order order = new Order(2);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order);
        owingPrinter.printOwing("Apple", orders);
        String expectedResult = "*****************************\n" +
                "****** Customer totals ******\n" +
                "*****************************\n" +
                "name: Apple\n" +
                "amount: 4.0\n";
        assertEquals(expectedResult, outContent.toString());
    }
}