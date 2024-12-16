package net.javaguides.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @NotEmpty(message = "User first name should not be null or empty") // User first name should not be null or empty
    private String firstName;
    @NotEmpty(message = "User last name should not be null or empty") // User last name should not be null or empty
    private String lastName;
    @NotEmpty(message = "User email should not be null or empty") // User email should not be null or empty
    @Email(message = "Email format not valid!")    // User email valid format email
    private String email;
}
