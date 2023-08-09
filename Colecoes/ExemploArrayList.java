package Colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ExemploArrayList {
    Random rd = new Random();

    ArrayList<String> carros = new ArrayList<>();

    public void teste() {
        // Adicionando elementos
        carros.add("Fusca");
        carros.add("Brasilia");
        carros.add("Chevette");
        carros.add("Monza");
        System.out.println(carros);
        // Ordenando a lista (.sort(Collections))
        Collections.sort(carros);
        System.out.println(carros);
        Collections.reverse(carros);
        System.out.println(carros);
        // Percorrer a lista
        for (int i = 0; i < carros.size(); i++) {
            System.out.println(carros.get(i));
        }

        System.out.println(" ");
        // Percorrendo a lista com a For-each
        for (String string : carros) {
            System.out.println(string);
        }
        // Limpando a lista
        carros.clear();
    }

    public void exercicio1() {
        // Criar um arrayList de numero inteiros | escrever 5 nºs - ordenar e imprimir
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(rd.nextInt(10));
        numeros.add(rd.nextInt(10));
        numeros.add(rd.nextInt(10));
        numeros.add(rd.nextInt(10));
        numeros.add(rd.nextInt(10));
        System.out.println(numeros);

        // Ordenando a lista
        Collections.sort(numeros);
        System.out.println(numeros);
        Collections.reverse(numeros);
        System.out.println(numeros);
    }
}
