package _12_Java_Collection_Framework.Practice.Binary_Search;

public interface Tree<E> {
    boolean insert(E e);
    void inorder();
    int getSize();
    void postorder();
    void preorder();
}
