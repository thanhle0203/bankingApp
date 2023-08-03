package com.thanhle.DTO;

import java.time.LocalDate;

import com.thanhle.domain.Address;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupForm {
    private String userName;
    private String password;
    private String customerName;
    private String customerGender;
    private LocalDate customerDob;
    private String customerMobileNum;
    private Address customerAddress; // Address class here
    private String realId;
    // Getters and setters...
}
