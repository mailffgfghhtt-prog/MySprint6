package com.example;
import java.util.List;
public class Lion {
    private final Predator predator;
    private final boolean hasMane;
    public Lion(Predator predator, String sex) throws Exception {
        this.predator = predator;
        if ("Самец".equals(sex)) {
            this.hasMane = true;
        } else if ("Самка".equals(sex)) {
            this.hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного — самец или самка");
        }
    }
    public int getKittens() {
        return 1;
    }
    public boolean doesHaveMane() {
        return hasMane;
    }
    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}