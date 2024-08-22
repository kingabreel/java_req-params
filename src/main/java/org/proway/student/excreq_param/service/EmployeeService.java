package org.proway.student.excreq_param.service;

import org.proway.student.excreq_param.model.Employee;
import org.proway.student.excreq_param.repository.EmployeeRepository;
import org.proway.student.excreq_param.service.specification.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getEmployee(String firstName, String lastName, String position, Double minSalary, Date hiredAfter, Date hiredBefore, Integer active) {
        Specification<Employee> spec = Specification
                .where(EmployeeSpecification.byFirstName(firstName))
                .and(EmployeeSpecification.byLastName(lastName))
                .and(EmployeeSpecification.byPosition(position))
                .and(EmployeeSpecification.byMinSalary(minSalary))
                .and(EmployeeSpecification.byDateRange(hiredAfter, hiredBefore))
                .and(EmployeeSpecification.istActive(active));

        return repository.findAll(spec);
    }

}
