package com.example;
import java.util.List;
public class Lion {
    private final Feline feline;
    private final boolean hasMane;
    public Lion(Feline feline, String sex) {
        this.feline = feline;
        if ("Самец".equals(sex)) {
            this.hasMane = true;
        } else if ("Самка".equals(sex)) {
            this.hasMane = false;
        } else {
            throw new IllegalArgumentException(
                    "Используйте допустимые значения пола животного — самец или самка"
            );
        }
    }
    public int getKittens() {
        return getKittens(1);
    }
    public int getKittens(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Количество котят не может быть отрицательным");
        }
        if (count > 10) {
            throw new IllegalArgumentException("Слишком много котят: максимум 10");
        }
        return count;
    }
    public boolean doesHaveMane() {
        return hasMane;
    }
    public List<String> getFood() throws Exception {
        return feline.eatMeat();
    }
}