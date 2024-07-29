package net.duchung.springboot_webflux_tutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
