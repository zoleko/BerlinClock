package com.bc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BcApplicationTests {

    @Test
    void Single_Minutes_Row() {
        BerlinClock berlinClock = new BerlinClock();
        assertEquals(berlinClock.getSingleMinutes("00:00:00"), "OOOO");
        assertEquals(berlinClock.getSingleMinutes("23:59:59"), "YYYY");
        assertEquals(berlinClock.getSingleMinutes("12:32:00"), "YYOO");
        assertEquals(berlinClock.getSingleMinutes("12:34:00"), "YYYY");
        assertEquals(berlinClock.getSingleMinutes("12:35:00"), "OOOO");
    }

    @Test
    void Five_Minutes_Row() {
        BerlinClock berlinClock = new BerlinClock();
        assertEquals(berlinClock.getFiveMinutes("00:00:00"), "OOOOOOOOOOO");
        assertEquals(berlinClock.getFiveMinutes("23:59:59"), "YYRYYRYYRYY");
        assertEquals(berlinClock.getFiveMinutes("12:04:00"), "OOOOOOOOOOO");
        assertEquals(berlinClock.getFiveMinutes("12:23:00"), "YYRYOOOOOOO");
        assertEquals(berlinClock.getFiveMinutes("12:35:00"), "YYRYYRYOOOO");
    }

    @Test
    void Single_Hours_Row() {
        BerlinClock berlinClock = new BerlinClock();
        assertEquals(berlinClock.getSingleHours("00:00:00"), "OOOO");
        assertEquals(berlinClock.getSingleHours("23:59:59"), "RRRO");
        assertEquals(berlinClock.getSingleHours("02:04:00"), "RROO");
        assertEquals(berlinClock.getSingleHours("08:23:00"), "RRRO");
        assertEquals(berlinClock.getSingleHours("14:35:00"), "RRRR");
    }

    @Test
    void Five_Hours_Row() {
        BerlinClock berlinClock = new BerlinClock();
        assertEquals(berlinClock.getFiveHours("00:00:00"), "OOOO");
        assertEquals(berlinClock.getFiveHours("23:59:59"), "RRRR");
        assertEquals(berlinClock.getFiveHours("02:04:00"), "OOOO");
        assertEquals(berlinClock.getFiveHours("08:23:00"), "ROOO");
        assertEquals(berlinClock.getFiveHours("16:35:00"), "RRRO");
    }

    @Test
    void Seconds_Lamp() {
        BerlinClock berlinClock = new BerlinClock();
        assertEquals(berlinClock.getSeconds("00:00:00"), "Y");
        assertEquals(berlinClock.getSeconds("23:59:59"), "O");
    }

    @Test
    void Entire_Berlin_Cloak() {
        BerlinClock berlinClock = new BerlinClock();
        assertEquals(berlinClock.getCloak("00:00:00"), "Y OOOO OOOO OOOOOOOOOOO OOOO");
        assertEquals(berlinClock.getCloak("23:59:59"), "ORRRRRRROYYRYYRYYRYYYYYY");
        assertEquals(berlinClock.getCloak("16:50:06"), "YRRROROOOYYRYYRYYRYOOOOO");
        assertEquals(berlinClock.getCloak("11:37:01"), "ORROOROOOYYRYYRYOOOOYYOO");
    }

    @Test
    void Berlin_Time_to_Digital_Time() {
        BerlinClock berlinClock = new BerlinClock();
        assertEquals(berlinClock.toDigital("YOOOOOOOOOOOOOOOOOOOOOOO"), "00:00:00");
        assertEquals(berlinClock.toDigital("ORRRRRRROYYRYYRYYRYYYYYY"), "23:59:59");
        assertEquals(berlinClock.toDigital("YRRROROOOYYRYYRYYRYOOOOO"), "16:50:00");
        assertEquals(berlinClock.toDigital("ORROOROOOYYRYYRYOOOOYYOO"), "11:37:59");
    }

}
