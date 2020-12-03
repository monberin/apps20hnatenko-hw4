package ua.edu.ucu.immutable;

import java.util.Arrays;

public class ImmutableLinkedList implements ImmutableList {
    private int size = 0;
    private Node head;
    private Node tail;

    public ImmutableLinkedList() {

    }

    public ImmutableLinkedList(Object[] list) {
        for (Object o : list) {
            Node node = new Node(o, null, null);
            if (size == 0) {
                this.head = node;
            }
            else {
                this.tail.setNext(node);
                node.setPrev(this.tail);
            }
            this.tail = node;
            size += 1;
        }
    }

    void checkIndexException(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return addAll(size, new Object[]{e});
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        checkIndexException(index);
        Object[] arr = new Object[c.length + size];
        int i = 0, j = 0;
        Node current = this.head;

        for (i = 0; i < index; i++) {
            arr[i] = current.getVal();
            current = current.getNext();

        }
        for (j = 0; j < c.length; j++) {
            arr[index+j] = c[j];
        }

        for (int q = i + j; q < arr.length; q++) {
            arr[q] = current.getVal();
            current = current.getNext();
        }
        return new ImmutableLinkedList(arr);
    }

    @Override
    public Object get(int index) {
        checkIndexException(index);
        Node node = this.head;
        int i = 0;
        while (i < index) {
            node = node.getNext();
            i += 1;
        }
        return node.getVal();
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        checkIndexException(index);
        Object[] arr = new Object[size-1];
        Node current = head;
        int j = 0;
        int i = 0;
//        for (int i= 0; i <= arr.length; i++)
        while (current != null)
        {
            if (i != index)
            {
                arr[j] = current.getVal();
                j++;
            }
            current = current.getNext();
            i++;
        }
        return new ImmutableLinkedList(arr);
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        checkIndexException(index);
        Object[] arr = new Object[size];
        Node current = this.head;

        for (int i = 0; i < arr.length; i++)
        {
            if (i != index)
            {
                arr[i] = current.getVal();
            }
            else {
                arr[i] = e;
            }
            current = current.getNext();
        }
        return new ImmutableLinkedList(arr);
    }


    @Override
    public int indexOf(Object e) {
        Node current = this.head;
        for (int i = 0; i < this.size; i++) {
            if (current.getVal() == e) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node current = this.head;

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = current.getVal();
            current = current.getNext();
        }
        return arr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    } // додає елемент у початок зв'язаного списку


    public ImmutableLinkedList addLast(Object e) {
        if (size > 0) {
            return add(this.size, e);
        }
        return add(0, e);
    } // додає елемент у кінець зв'язаного списку


    public Object getFirst() {
        return get(0);
    }


    public Object getLast() {
        if (size > 0) {
            return get(this.size - 1);
        }
        return -1;
    }


    public ImmutableLinkedList removeFirst() {
        if (size > 0) {
            return remove(0);
        }
        return new ImmutableLinkedList();
    } // видаляє перший елемент



    public ImmutableLinkedList removeLast() {
        if (size > 0) {
            return remove(this.size - 1);
        }
        return new ImmutableLinkedList();
    } // видаляє останній елемент

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
