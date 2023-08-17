package _15_Debug.Demo.AgeException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scan.nextInt();

        try{
            checkAge(age);
        }
        catch(Exception e)
        {
            System.out.println("A problem occurred: "+e);
        }
    }

    static void checkAge(int age)throws AgeException{

        if(age<18) {
            throw new AgeException("\nYou must be 18+ to sign up", new RuntimeException());
        }
        else {
            System.out.println("You are now signed up!");
        }
    }
}
