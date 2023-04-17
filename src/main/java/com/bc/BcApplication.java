package com.bc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BcApplication {

    public static void main(String[] args) {

        SpringApplication.run(BcApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nFeature 1 - Converting Digital Time to Berlin Time");
        System.out.println("Enter time : ");
        String time = scanner.next();
        BerlinClock berlinClock = new BerlinClock();
        System.out.println("Berlin clock is : " + berlinClock.getCloak(time));

        System.out.println("\n\nFeature 2 - Converting Berlin Time to Digital Time");
        System.out.println("Enter berlin time : ");
        String btime = scanner.next();
        System.out.println("Digital Time is : " + berlinClock.toDigital(btime));
    }

}
