package com.asd.caselocationsmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class CaseLocationsMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseLocationsMapApplication.class, args);
    }

}
