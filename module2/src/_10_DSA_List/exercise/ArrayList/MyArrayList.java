package _10_DSA_List.exercise.ArrayList;

import java.util.Arrays;

public class MyArrayList<E> {
    private int size;
    private static final int DEFAULT_CAPACITY;
    private E[] elements;
    static {
        DEFAULT_CAPACITY = 2;
    }

    public MyArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public void add(int index, E element) {
        ensureCapacity();
        for (int i=size; i>index; i-- ) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }
    public E remove(int index) {
        Object e = elements[index];
        for (int i=index; i<size-1; i++) {
            elements[i] = elements[i+1];
        }
        elements[size-1] = null;
        size--;
        return (E) e;
    }
    public boolean contains(E element) {
        for (int i=0; i<size; i++) {
            if (element.equals(elements[i])) return true;
        }
        return false;
    }

    public int indexOf (E element) {
        for (int i=0; i<size; i++) {
            if (element.equals((elements[i]))) return i;
        }
        return -1;
    }
    public void ensureCapacity() {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }
    public E get(int index) {
        return (E) elements[index];
    }
    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    @Override
    public String toString() {
        return "MyArrayList{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
