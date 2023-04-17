package com.bc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.stream.IntStream;

public class BerlinClock {
    Logger log = LoggerFactory.getLogger(BerlinClock.class);


    public String getSingleMinutes(String time) {
        StringBuilder sb = new StringBuilder();
        LocalTime ltime = LocalTime.parse(time);
        int minutes = ltime.getMinute();
        IntStream.rangeClosed(1, 4).forEach(i -> sb.append(i <= minutes % 5 ? "Y" : "O"));
        return sb.toString();

    }

    public String getFiveMinutes(String time) {
        StringBuilder sb = new StringBuilder();
        LocalTime ltime = LocalTime.parse(time);
        int minutes = ltime.getMinute();
        log.trace(">>>>>minutes:" + minutes);
        IntStream.rangeClosed(1, 11).forEach(i -> sb.append(i <= minutes / 5 ? (i % 3 == 0 ? "R" : "Y") : "O"));
        return sb.toString();
    }

    public String getSingleHours(String time) {
        StringBuilder sb = new StringBuilder();
        LocalTime ltime = LocalTime.parse(time);
        int hours = ltime.getHour();
        log.trace(">>>>>hours:" + hours);
        IntStream.rangeClosed(1, 4).forEach(i -> sb.append(i <= hours % 5 ? "R" : "O"));
        return sb.toString();
    }

    public String getFiveHours(String time) {
        StringBuilder sb = new StringBuilder();
        LocalTime ltime = LocalTime.parse(time);
        int hours = ltime.getHour();
        log.trace(">>>>>hours:" + hours);
        IntStream.rangeClosed(1, 4).forEach(i -> sb.append(i <= hours / 5 ? "R" : "O"));
        return sb.toString();
    }

    public String getSeconds(String time) {
        LocalTime ltime = LocalTime.parse(time);
        int seconds = ltime.getSecond();
        log.trace(">>>>>seconds:" + seconds);
        return seconds % 2 == 0 ? "Y" : "O";
    }

    public String getCloak(String time) {
        StringBuilder sb = new StringBuilder();
        sb.append(getSeconds(time)).append(getFiveHours(time))
                .append(getSingleHours(time)).append(getFiveMinutes(time))
                .append(getSingleMinutes(time));
        return sb.toString();
    }

    public String toDigital(String berlincloak) {

        StringBuilder sb = new StringBuilder();
        String hours = new DecimalFormat("00").format(berlincloak.substring(1, 5).chars().filter(ch -> ch == 'R').count() * 5 +
                berlincloak.substring(5, 9).chars().filter(ch -> ch == 'R').count());
        String minutes = new DecimalFormat("00").format(berlincloak.substring(9, 20).chars().filter(ch -> ch == 'R' || ch == 'Y').count() * 5 +
                berlincloak.substring(20, 24).chars().filter(ch -> ch == 'Y').count());
        String seconds = berlincloak.charAt(0) == 'Y' ? "00" : "59";
        sb.append(hours)
                .append(":")
                .append(minutes)
                .append(":")
                .append(seconds);
        log.trace(">>>>>toDigital:" + sb.toString());
        return sb.toString();
    }
}
