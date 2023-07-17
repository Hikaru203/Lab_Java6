package com.example.demo.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {
    @NotBlank(message = "{NotEmpty.student.email}")
    @Email(message = "{Email.student.email}")
    private String email;

    @NotBlank(message = "{NotEmpty.student.fullName}")
    private String fullName;

    @NotNull(message = "{NotNull.student.marks}")
    @PositiveOrZero(message = "{PositiveOrZero.student.marks}")
    @Max(message = "{Max.student.marks}", value = 10)
    private Double marks;

    @NotNull(message = "{NotNull.student.gender}")
    private Boolean gender;

    @NotBlank(message = "{NotEmpty.student.country}")
    private String country;
}
