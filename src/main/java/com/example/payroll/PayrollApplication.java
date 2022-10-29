/*
 * To launch an application.
 * A Spring Boot application is, at a minimum,
 * a `public static void main` entry-point
 * and the `@SpringBootApplication` annotation.
 * This tells Spring Boot to help out, wherever possible.
 *
 * `@SpringBootApplication` is a meta-annotation that pulls in
 * component scanning, autoconfiguration, and property support.
 * In essence, it will fire up a servlet container and serve up our service.
 */

package com.example.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayrollApplication.class, args);
    }

}
