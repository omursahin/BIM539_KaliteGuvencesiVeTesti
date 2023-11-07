package org.software_testing.junit_example;

public class Example {
    public int quackAlot(Duck d, int num) {
        for (int j = 0; j < num; j++) {
            d.quack();
        }
        return num;
    }
}
