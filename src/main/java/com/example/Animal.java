package com.example;
import java.util.List;
public class Animal {
    public List<String> getFood(String animalKind) throws Exception {
        if (animalKind == null || animalKind.trim().isEmpty()) {
            throw new Exception("Вид животного не может быть null или пустым");
        }
        String normalized = animalKind.trim();
        if ("Травоядное".equals(normalized)) {
            return List.of("Трава", "Различные растения");
        } else if ("Хищник".equals(normalized)) {
            return List.of("Животные", "Птицы", "Рыба");
        } else {
            throw new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }
    public String getFamily() {
        return "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    }
}