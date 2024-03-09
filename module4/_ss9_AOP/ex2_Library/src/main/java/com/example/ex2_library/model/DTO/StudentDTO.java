package com.example.ex2_library.model.DTO;

import jakarta.validation.constraints.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;

public class StudentDTO implements Validator {

//    @NotNull
//    @NotEmpty
//    @NotBlank
//    @Size(min = 3, message = "> 3 characters")
//    @Size(max = 10, message = "< 10 characters")
//    @Pattern(regexp = "^[a-z ]*$", message = "only contain character")
//    @Min(value = 1, message = "")
//    @Max
//    @DateTimeFormat(pattern = "")
//    @Value("${otp.length}")
    @NotBlank(message = "Student Id can not be empty")
    private String studentId;
    @NotBlank(message = "Name can not be empty !!!")
    private String studentName;

    private LocalDate dob;
    private Long fptClass;

    public StudentDTO() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public StudentDTO(String studentName, LocalDate dob, Long fptClass) {
        this.studentName = studentName;
        this.dob = dob;
        this.fptClass = fptClass;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getFptClass() {
        return fptClass;
    }

    public void setFptClass(Long fptClass) {
        this.fptClass = fptClass;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDTO studentDTO = (StudentDTO) target;
        LocalDate dob = studentDTO.getDob();
        int age = Period.between(dob, LocalDate.now()).getYears();
        if (age < 18){
            errors.rejectValue("dob","","Age must be > 18");
        }
    }

}
