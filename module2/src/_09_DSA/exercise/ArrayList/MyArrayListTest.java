package _09_DSA.exercise.ArrayList;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();

        System.out.print("---------------\n LIST \n");
        myArrayList.add(0,"dat");                                  // ADD
        myArrayList.add(1,"duy");
        myArrayList.add(2,"bui");
        myArrayList.add(3,"minh");
        myArrayList.add(4,"phuc");
        System.out.println(myArrayList);

        System.out.print("--------------\n DELETE 'bui' and CHECK 'bui' \n");
        System.out.print("Contain bui : ");
        System.out.println(myArrayList.contains("bui"));                        // CONTAIN

        myArrayList.remove(2);                                            // REMOVE and CONTAIN
        System.out.println(myArrayList);
        System.out.print("Contain bui : ");
        System.out.println(myArrayList.contains("bui"));

        System.out.print("---------------- \n ADD 'NAM' \n");
        myArrayList.add(2,"NAM");
        System.out.println(myArrayList);

        System.out.println("Size : " + myArrayList.size());                 // SIZE

        System.out.println("---------------");                                 // CHECK E of Index
        System.out.println("CHECK E of INDEX");
        System.out.print("Minh : ");
        System.out.println(myArrayList.indexOf("Minh"));
        System.out.print("minh : ");
        System.out.println(myArrayList.indexOf("minh"));

        System.out.print("---------------\n Get E of Index \n");               // GET E of Index
        for (int i=0; i< myArrayList.size();i++) {
            System.out.println("Index " + i + " : " + myArrayList.get(i));
        }

        System.out.print("--------------\n CLEAR LIST \n");                    // CLEAR
        myArrayList.clear();
        System.out.println(myArrayList);
    }
}
