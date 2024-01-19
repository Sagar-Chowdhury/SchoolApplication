package com.example.SchoolApp.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Contact {

    @NotBlank(message = "Name Must Not be Blank")
    @Size(min = 3, message = "Name Must be at least 3 characters long")
    private String name;

    @NotBlank(message = "Mobile No must not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})" , message ="Mobile Number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Email Should not be blank")
    @Email(message = "Please Provide Email Address")
    private String email;

    @NotBlank(message = "Subject Must not be blank")
    @Size(min=5, message = "Subject Must be at least 5 characters long")
    private String subject;

    @NotBlank(message = "Message must not be blank")
    @Size(min=10, message="Message must be at least 10 characters long")
    private String message;


}
