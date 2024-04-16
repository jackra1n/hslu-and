package ch.hslu.exercises.SW02;

public class MyCustomLinkedList<E> {
    private Node<E> element;

    public MyCustomLinkedList() {
        element = null;
    }

    public void add(E element) {
        this.element = new Node<>(element, this.element);
    }



    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

}
