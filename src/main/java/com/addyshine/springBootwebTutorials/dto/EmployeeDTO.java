package com.addyshine.springBootwebTutorials.dto;

import com.addyshine.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTO {
    private Long id;

    @NotEmpty(message = "NAME OF THE EMPLOYEE CANNOT BE EMPTY")
    @Size(min= 3, max = 50, message="number of characters in name should be in the range(3,50)")
    private String name;

    @NotBlank(message="email should not be null")
    @Email(message= " Email should b a valid email")
    private String email;

    @NotNull(message="age should not be null")
    @Max(value=80 , message = "Age cannot be greater than 80")
    @Min(value=18 , message=" age cannot be lesser than 18")
    private Integer age;


    @NotEmpty(message=" the role of the user should not be null")
    //@Pattern(regexp = "^(ADMIN|USER)$",message=" role of emplyee can either be USER or ADMIN" )

    @EmployeeRoleValidation
    private String role; //  ADMIN | USER


    @NotNull(message="salary should not be null") @Positive(message = "sallary of employee should be positive")
    @Digits(integer = 7,fraction = 2,message="salary cant be in the xxxxxx")

    @DecimalMin(value="100.50")
    @DecimalMax(value="10000.99")

    private Double salary;

    @PastOrPresent(message=" dateofjoining field in employee cant be in future")
    private LocalDate dateofjoining;


    @AssertTrue(message="employee should be true")
    @JsonProperty("isActive")
    private Boolean isActive;


}