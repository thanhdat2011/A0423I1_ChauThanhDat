package ss08_mvc.controller;

import ss08_mvc.model.Student;
import ss08_mvc.service.StudentService;
import ss08_mvc.service.StudentServiceImpl;

import java.util.Scanner;

/**
 * (C) Copyright 2023 CodeGym Da Nang. All Rights Reserved.
 *
 * @author caube
 * @version 1.0
 * @see <a href="https://danang.codegym.vn/">CodeGym Da Nang</a>
 * @since 7/31/2023
 */
public class StudentController {
    private static StudentService service = (StudentService) new StudentServiceImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        do {
            System.out.println("-------Student Manager------");
            System.out.println("1. List");
            System.out.println("2. Add new student");
            System.out.println("3. Update");
            System.out.println("9. Exit");
            System.out.print("Please input number: ");
            select = Integer.parseInt(scanner.nextLine());
            switch (select){
                case 1: //list
                    Student[] students = service.findAll();
                    for(Student student: students){
                        System.out.println(student);
                    }
                    break;
                case 2: //add
                    System.out.print("input id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("input name: ");
                    String name = scanner.nextLine();
                    Student student = new Student(id, name);

                    service.addStudent(student);
                    break;
                case 9://exit
                    System.exit(0);
            }
        }while (true);
    }
}
