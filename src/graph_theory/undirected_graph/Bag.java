package graph_theory.undirected_graph;

import java.util.Iterator;

/**
 * Created by Vincent on 2016/4/16.
 * 一个带迭代器的链表结构
 */
public class Bag<Item> implements Iterable<Item>{


    private Node first;

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node{
        Item item;
        Node next;
    }

    public void add(Item item){
        Node oldFirst = first;
        Node first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    private class ListIterator implements Iterator<Item>{

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item res = current.item;
            current = current.next;
            return res;
        }

        @Override
        public void remove() {

        }
    }

}
