package com.kirilo.patterns.behavioral.template_method;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Iterator;

public class ElementRepository {
    private NodeList nodes;
    private NodeIterator iterator;

    public ElementRepository(NodeList nodes) {
        this.nodes = nodes;
        iterator = new NodeIterator();
    }

    public Element getNextElement() {
        Node node = iterator.next();
        if (node == null) {
            return null;
        }
        if (node.getNodeType() != Node.ELEMENT_NODE) {
            getNextElement();
        }
        return new Element(node.getNodeName());
    }

    private class NodeIterator implements Iterator<Node> {
        private int index;

        @Override
        public boolean hasNext() {
            return nodes != null && index < nodes.getLength();
        }

        @Override
        public Node next() {
            return hasNext() ? nodes.item(index++) : null;
        }
    }

}
