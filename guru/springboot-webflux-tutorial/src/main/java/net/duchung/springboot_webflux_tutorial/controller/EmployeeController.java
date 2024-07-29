package net.duchung.springboot_webflux_tutorial.controller;

import lombok.AllArgsConstructor;
import net.duchung.springboot_webflux_tutorial.dto.EmployeeDto;
import net.duchung.springboot_webflux_tutorial.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

    @GetMapping("/{id}")
    public Mono<EmployeeDto> getEmployee( @PathVariable("id") String id){
        return employeeService.getEmployee(id);
    }

    @GetMapping("/getAll")
    public Flux<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public Mono<EmployeeDto> updateEmployee(@PathVariable("id") String id, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(employeeDto, id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployee(@PathVariable("id") String id){
        return employeeService.deleteEmployee(id);
    }
}
