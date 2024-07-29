package net.duchung.springboot_webflux_tutorial.service.impl;

import lombok.AllArgsConstructor;
import net.duchung.springboot_webflux_tutorial.dto.EmployeeDto;
import net.duchung.springboot_webflux_tutorial.entity.Employee;
import net.duchung.springboot_webflux_tutorial.mapper.EmployeeMapper;
import net.duchung.springboot_webflux_tutorial.repository.EmployeeRepository;
import net.duchung.springboot_webflux_tutorial.service.EmployeeService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.toEntity(employeeDto);
        return employeeRepository.save(employee).map(EmployeeMapper::toDto);
    }

    @Override
    public Mono<EmployeeDto> getEmployee(String employeeId) {
        return employeeRepository.findById(employeeId).map(EmployeeMapper::toDto);
    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().map(EmployeeMapper::toDto);
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String id) {
        Mono<Employee> employeeMono =employeeRepository.findById(id);

        Mono<Employee> updateEmployee = employeeMono.flatMap(employee -> {
            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setEmail(employeeDto.getEmail());
            return employeeRepository.save(employee);
        });
        return updateEmployee.map(EmployeeMapper::toDto);
    }

    @Override
    public Mono<Void> deleteEmployee(String id) {
        return employeeRepository.deleteById(id);
    }
}
