package com.kirilo.patterns.behavioral.iterator;

public class Demo {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for (Iterator iterator = nameRepository.getIterator(); iterator.hasNext(); ) {
            String nextName = (String) iterator.getNext();
            System.out.println("Name: " + nextName);
        }
    }
}
