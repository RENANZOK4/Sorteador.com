package com.example.Sorteador.Model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Sorteio {

    public static List<Integer> sortearNumeros(int quantidade, int minimo, int maximo) {
        Random random = new Random();
        return random.ints(quantidade, minimo, maximo + 1)
                .boxed()
                .collect(Collectors.toList());
    }
}
