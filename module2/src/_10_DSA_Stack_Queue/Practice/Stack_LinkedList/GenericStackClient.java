package _10_DSA_Stack_Queue.Practice.Stack_LinkedList;

public class GenericStackClient {
    public static void stackOfString() {
        MyGenericStack<String> stringMyGenericStack = new MyGenericStack<>();
        stringMyGenericStack.push("dat");
        stringMyGenericStack.push("duy");
        stringMyGenericStack.push("duc");
        stringMyGenericStack.push("bim");
        stringMyGenericStack.push("tuyen");
        System.out.println("-----------String-----------");
        while (!stringMyGenericStack.isEmpty()) {
            System.out.println(stringMyGenericStack.pop());
        }
    }
    public static void  stackOfInteger() {
        MyGenericStack<Integer> integerMyGenericStack = new MyGenericStack<>();
        integerMyGenericStack.push(11);
        integerMyGenericStack.push(15);
        integerMyGenericStack.push(1);
        integerMyGenericStack.push(9);
        integerMyGenericStack.push(7);
        integerMyGenericStack.push(20);
        System.out.println("----------Integer----------");
        while (!integerMyGenericStack.isEmpty()) {
            System.out.println(integerMyGenericStack.pop());
        }
    }
    public static void main(String[] args) {
        stackOfInteger();
        stackOfString();
    }
}
