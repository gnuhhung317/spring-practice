package net.duchung.springboot_webflux_tutorial;

import net.duchung.springboot_webflux_tutorial.dto.EmployeeDto;
import net.duchung.springboot_webflux_tutorial.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import javax.print.attribute.standard.Media;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTests {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testSaveEmployee() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("firstName");
        employeeDto.setLastName("lastName");
        employeeDto.setEmail("email");
        webTestClient.post()
                .uri("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(employeeDto), EmployeeDto.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("id").isNotEmpty()
                .jsonPath("firstName").isEqualTo(employeeDto.getFirstName())
                .jsonPath("lastName").isEqualTo(employeeDto.getLastName())
                .jsonPath("email").isEqualTo(employeeDto.getEmail());

    }
}
