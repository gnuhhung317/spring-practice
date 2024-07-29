package net.duchung.springboot_webflux_tutorial.mapper;

import net.duchung.springboot_webflux_tutorial.dto.EmployeeDto;
import net.duchung.springboot_webflux_tutorial.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto toDto(Employee employee){

        return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
    }
    public static Employee toEntity(EmployeeDto employeeDto){

        return new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail());
    }
}
