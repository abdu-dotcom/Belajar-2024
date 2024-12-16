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
    @NotEmpty // User first name should not be null or empty
    private String firstName;
    @NotEmpty // User last name should not be null or empty
    private String lastName;
    @NotEmpty // User email should not be null or empty
    @Email    // User email valid format email
    private String email;
}
