package com.example;
import com.example.Predator;
import java.util.List;
public class Feline implements Predator {
    @Override
    public List<String> eatMeat() throws Exception {
        return List.of("Животные", "Птицы", "Рыба");
    }
    public String getFamily() {
        return "Кошачьи";
    }
    public int getKittens() {
        return 1;
    }
    public int getKittens(int count) {
        return count;
    }
}