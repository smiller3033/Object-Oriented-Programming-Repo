import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    //CONSTRUCTOR
    LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //GETTERS
    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    //METHODS
    public void addAtIndex(T data, int index) {
        Node<T> current = this.head;
        Node<T> prev = null;
        int count = 0;
        if ((index > size) || (index < 0)) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        else if (data == null) {
            throw new IllegalArgumentException("You cannot add null data to the list");
        }
        else if (this.head == null) {
            this.head = new Node<T>(data, null);
            this.tail = this.head;
            this.size = 1;
        }
        else if (index == 0) {
            this.head = new Node<T>(data, this.head);
            this.size++;
        }
        else {
            while (count < index) {
                prev = current;
                current = current.getNext();
                count++;
            }
            current = new Node<T>(data, current);
            prev.setNext(current);
            if (index == size) {
                this.tail = current;
            }
            this.size++;
        }
    }

    public T getAtIndex(int index) {
        if ((index >= size) || (index < 0)) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        else{
            Node<T> current = head;
            int count = 0;
            T data = null;
            while (count <= index) {
                data = current.getData();
                current = current.getNext();
                count++;
            }
            return data;
        }
    }

    public T removeAtIndex(int index) {
        if ((index >= size) || (index < 0)) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        Node<T> current = this.head;
        Node<T> nextNext = null;
        T nextData = null;
        Node<T> prev = null;
        int count = 0;
        T returnData = current.getData();
        while (count < index) {
            prev = current;
            current = current.getNext();
            count++;
        }
        if (index == 0) {
            if (current.getNext() == null) {
                this.head = null;
                this.tail = null;
            }
            else{
                nextData = current.getNext().getData();
                nextNext = current.getNext().getNext();
                current.setData(nextData);
                current.setNext(nextNext);
                this.head = current;
            }
        }
        else if (current.getNext() == null) {
            returnData = current.getData();
            prev.setNext(null);
            this.tail = prev;
        }
        else {
            returnData = current.getData();
            nextData = current.getNext().getData();
            nextNext = current.getNext().getNext();
            current.setData(nextData);
            current.setNext(nextNext);
        }
        this.size--;
        return returnData;
    }

    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }
        Node<T> current = this.head;
        Node<T> nextNext = null;
        Node<T> prev = this.head;
        T nextData = null;
        T checkData = null;
        int i = -1;
        T returnData = null;
        for (i = 0; i < this.size; i++) {
            checkData = current.getData();
            returnData = current.getData();
            if (data.equals(checkData)) {
                if (i == 0) {
                    if (current.getNext() == null) {
                        this.head = null;
                        this.tail = null;
                    }
                    else{
                        nextData = current.getNext().getData();
                        nextNext = current.getNext().getNext();
                        current.setData(nextData);
                        current.setNext(nextNext);
                        this.head = current;
                    }
                }
                else if (i == this.size - 1) {
                    prev.setNext(null);
                    this.tail = prev;
                }
                else {
                    nextData = current.getNext().getData();
                    nextNext = current.getNext().getNext();
                    current.setData(nextData);
                    current.setNext(nextNext);
                }
                break;
            }
            prev = current;
            current = current.getNext();
        }
        if (!data.equals(checkData)) {
            throw new NoSuchElementException("The data is not present in the list.");
        }
        this.size--;
        return returnData;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return this.size;
    }
}