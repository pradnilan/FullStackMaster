package org.prad.client;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class Temp1 {

    public static void main(String[] args) {
        System.out.println(LocalDate.of(2022, Month.JULY,1));
        LocalTime t1=LocalTime.of(10,00,00);
        LocalTime t2=LocalTime.of(11,10,00);
        LocalTime t3=LocalTime.of(t2.getHour()- t1.getHour(), t2.getMinute()-t1.getMinute());
        System.out.println(t3);
    }
}
