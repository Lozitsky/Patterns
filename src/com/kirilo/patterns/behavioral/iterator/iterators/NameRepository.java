package com.kirilo.patterns.behavioral.iterator.iterators;

public class NameRepository implements Container {
    private String[] names;

    public NameRepository() {
        lazyInit();
    }

    public NameRepository(String[] names) {
        this.names = names;
    }

    private void lazyInit() {
        if (names == null) {
            names = new String[]{"Robert", "John", "Julie", "Lora"};
        }
    }

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        private int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object getNext() {
            return this.hasNext() ? names[index++] : null;
        }
    }
}
