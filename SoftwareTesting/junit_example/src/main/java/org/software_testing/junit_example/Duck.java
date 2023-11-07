package org.software_testing.junit_example;

public class Duck {
    boolean alive = true;

    public int quack(){
        System.out.println("Quack");
        return 0;
    }

    public void shoot(){
        boolean hit = true; //karmaşık bir yörünge hesabı sonucu

        if (hit) alive = false;
    }

    public String toString(){
        return alive ? "alive" : "dead";
    }
}

