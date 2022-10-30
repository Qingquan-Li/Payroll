/*
 * Using Spring MVC to wrap the repository with a web layer.
 */

package com.example.payroll;

// import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// `@RestController` indicates that the data returned by each method will be
// written straight into the response body instead of rendering a template.
@RestController
class EmployeeController {

    private final EmployeeRepository repository;

    /**
     * An EmployeeRepository is injected by constructor into the controller.
     * @param repository
     */
    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/employees")
    List<Employee> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    /**
     * The way you construct your service can have significant impacts.
     * In this situation, we said update, but replace is a better description.
     * For example, if the name was NOT provided, it would instead get nulled
     * out.
     * @param newEmployee
     * @param id
     * @return
     */
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee,
                             @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
