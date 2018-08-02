package com.example.demo.employee;

import com.example.demo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where e.department.id = :depId")
    List<Employee> findByDepartmentId(@Param("depId") Long depId);
}
