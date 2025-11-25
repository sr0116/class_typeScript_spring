package com.imchbo.exgraphql.repository;

import com.imchbo.exgraphql.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
