package com.epam.training;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class represents person.
 *
 * @author vkrasovsky
 */
public class Person {
    private String name;
    private double amount;
    private static final Logger LOGGER = LogManager.getLogger(Person.class);

    public Person(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public synchronized void add(double amount, Person person) {
        LOGGER.debug("[" + Thread.currentThread().getName() + "]: " + this.getName() + " (+) " + amount);
        this.amount = this.amount + amount;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.debug(e.getMessage());
        }
        person.sub(amount, person);
    }

    public synchronized void sub(double amount, Person person) {
        LOGGER.debug("[" + Thread.currentThread().getName() + "]: " + person.getName() + " (-) " + amount);
        this.amount = this.amount - amount;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.debug(e.getMessage());
        }
    }

    public double getBalance() {
        return amount;
    }

    public String getName() {
        return name;
    }
}
