package org.alien.heimdall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeimdallApplication {

    public static void main(String[] args){
        SpringApplication.run(HeimdallApplication.class, args);
        System.out.print("Heimdall Started!!!");
    }
}
