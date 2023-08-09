package _09_DSA_List.practice.Simpl_ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        // Interget List
        MyList<Integer> intergerList = new MyList<Integer>();
        intergerList.add(5);
        intergerList.add(2);
        intergerList.add(3);
        System.out.println(intergerList);
        System.out.println(intergerList.get(2));
    //    System.out.println(intergerList.get(-1));

        // String List
        System.out.println("---------------");
        MyList<String> stringList = new MyList<String>();
        stringList.add("Dat");
        stringList.add("Duy");
        stringList.add("Bui");
        System.out.println(stringList);
    }
}
