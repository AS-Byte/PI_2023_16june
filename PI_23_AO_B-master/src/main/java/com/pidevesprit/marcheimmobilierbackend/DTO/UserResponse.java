package com.pidevesprit.marcheimmobilierbackend.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String profession;
    private String num;
    private String birthdate;
    private String role;
    private byte[] image;
}