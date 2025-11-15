package com.example;

import java.util.List;

public interface Predator {
    List<String> eatMeat() throws Exception;  // Уже было: важно, чтобы здесь был throws
}
