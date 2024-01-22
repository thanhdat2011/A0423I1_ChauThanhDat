package com.example.springboot.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

// Data transfer object - sử dụng để validate đữ liệu
public class StudentDTO implements Validator {
    @NotBlank(message = "The student's name must not be empty")
    @Size(min = 3, message = "> 3 characters")
    @Size(max = 10, message = "< 10 characters")
    @Pattern(regexp = "^[a-z ]*$", message = "only contain character")
    private String name;
    @Size(min = 5, message = "{email.min}")
    private String email;
    private Long codeGymClass;

    public StudentDTO() {
    }

    public StudentDTO(String name, String email, Long codeGymClass) {
        this.name = name;
        this.email = email;
        this.codeGymClass = codeGymClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCodeGymClass() {
        return codeGymClass;
    }

    public void setCodeGymClass(Long codeGymClass) {
        this.codeGymClass = codeGymClass;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDTO studentDTO = (StudentDTO) target;
        String email = studentDTO.getEmail();
        if("".equals(email)) {
            errors.rejectValue("email","","Can not be empty");
        }else if(email.length() < 5) {
            errors.rejectValue("email","email.min");
        }
    }
}
