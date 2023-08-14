package _12_Java_Collection_Framework.Practice.Binary_Search;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(27);
        tree.insert(14);
        tree.insert(35);
        tree.insert(10);
        tree.insert(31);
        tree.insert(19);
        tree.insert(42);
        System.out.println("Inorder : ");
        tree.inorder();
        System.out.println("Size : " + tree.getSize());
        System.out.println("-------------------------");
        System.out.println("Postorder : ");
        tree.postorder();
        System.out.println("-------------------------");
        System.out.println("Preorder : ");
        tree.preorder();
        System.out.println("---------------------------");
        System.out.println(tree.search(30));
        System.out.println(tree.search(31));
    }
}
