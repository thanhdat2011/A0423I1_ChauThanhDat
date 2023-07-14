package _01_introduction_to_java.practice;

import java.util.Scanner;

public class p7_BMI_body {
    public static void main(String[] args) {
        System.out.println("Body mass index-BMI");
        Scanner sc = new Scanner(System.in);
        float weight;
        float height;

        System.out.println("What is your weight (kg) ?");
        weight = sc.nextFloat();
        System.out.println("What is your height (cm) ?");
        height = sc.nextFloat();

        float bmi = weight / ((height/100) * (height/100));

        System.out.println("Your BMI = " + bmi);

        if (bmi >= 0) {
            if (bmi < 18.5) {
                System.out.println("Underweight");
            } else if (bmi < 25.0) {
                System.out.println("Normal");
            } else if (bmi < 30.0) {
                System.out.println("Overweight");
            } else
                System.out.println("Obese");
        }

    }
}
