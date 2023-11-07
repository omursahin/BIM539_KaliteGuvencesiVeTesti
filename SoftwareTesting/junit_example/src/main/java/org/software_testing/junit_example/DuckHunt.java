package org.software_testing.junit_example;

public class DuckHunt {
    public void shootDuck(Duck d) {
        System.out.println(d.toString());
        d.shoot();
        System.out.println(d.toString());
    }
}