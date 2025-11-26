package com.imchbo.exgraphql.graphql;

import com.imchbo.exgraphql.domain.Employee;
import com.imchbo.exgraphql.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeGraphQLController {

    private final EmployeeRepository employeeRepository;

    // GraphQL 필드명: employees
    @QueryMapping
    public List<Employee> employees() {
        return employeeRepository.findAll();
    }

    // GraphQL 필드명: employee
    @QueryMapping
    public Employee employee(@Argument Long id) {
        return employeeRepository.findById(id).orElse(null);
    }


    // 빌더 패턴 사용
    @MutationMapping
    public Employee createEmployee(@Argument("input") EmployeeInput input) {

        Employee emp = Employee.builder()
                .name(input.name())
                .age(input.age())
                .job(input.job())
                .language(input.language())
                .pay(input.pay())
                .build();

        return employeeRepository.save(emp);
    }

    @MutationMapping
    public Employee updateEmployee(@Argument Long id, @Argument("input") EmployeeInput input) {

        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setName(input.name());
        emp.setAge(input.age());
        emp.setJob(input.job());
        emp.setLanguage(input.language());
        emp.setPay(input.pay());

        return employeeRepository.save(emp);
    }

    @MutationMapping
    public Boolean deleteEmployee(@Argument Long id) {

        if (!employeeRepository.existsById(id)) {
            throw new IllegalIdentifierException("Employee does not exist");
        }

        employeeRepository.deleteById(id);
        return true;
    }
}
