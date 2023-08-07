package _09_DSA.practice.Simpl_ArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY;
    private Object[] elements;
    static{
        DEFAULT_CAPACITY = 2;
    }

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public int getSize() {
        return size;
    }

    private void ensureCapacity() {
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;                   // size trong [] = 0 -> sau khi ket thuc dong lenh : size = 1
    }
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
