package net.hung.registration_login_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty

    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    private String password;

}
