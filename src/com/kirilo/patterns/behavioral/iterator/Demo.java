package com.kirilo.patterns.behavioral.iterator;

import com.kirilo.patterns.behavioral.iterator.iterators.Iterator;
import com.kirilo.patterns.behavioral.iterator.iterators.NameRepository;

public class Demo {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for (Iterator iterator = nameRepository.getIterator(); iterator.hasNext(); ) {
            String nextName = (String) iterator.getNext();
            System.out.println("Name: " + nextName);
        }
    }
}
