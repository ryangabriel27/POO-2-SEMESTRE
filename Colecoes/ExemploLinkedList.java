package Colecoes;

import java.util.LinkedList;

public class ExemploLinkedList {
    LinkedList <String> pessoas = new LinkedList<>();

    public void teste() {
        pessoas.add("Pedro");
        pessoas.add("Maria");
        pessoas.add("João");
        
        pessoas.addFirst("Cecília");

        pessoas.removeLast();

        System.out.println(pessoas);


    }
}
