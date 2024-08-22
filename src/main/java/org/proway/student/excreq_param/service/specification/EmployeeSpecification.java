package org.proway.student.excreq_param.service.specification;

import org.proway.student.excreq_param.model.Employee;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class EmployeeSpecification {
    public static Specification<Employee> byFirstName(String firstName){
        return ((root, query, criteriaBuilder) -> firstName == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%"));
    }
    public static Specification<Employee> byLastName(String lastName){
        return ((root, query, criteriaBuilder) -> lastName == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), "%" + lastName.toLowerCase() + "%"));

    }
    public static Specification<Employee> byPosition(String position){
        return ((root, query, criteriaBuilder) -> position == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("position")), "%" + position + "%"));

    }
    public static Specification<Employee> byMinSalary(Double minSalary) {
        return ((root, query, criteriaBuilder) -> minSalary == null ? null : criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), minSalary));
    }
    public static Specification<Employee> byDateRange(Date hiredAfter, Date hiredBefore) {
        return (root, query, criteriaBuilder) -> {
            if (hiredAfter != null && hiredBefore != null) return criteriaBuilder.between(root.get("hireDate"), hiredAfter, hiredBefore);
            else if (hiredAfter != null) return criteriaBuilder.greaterThanOrEqualTo(root.get("hireDate"), hiredAfter);
            else if (hiredBefore != null) return criteriaBuilder.lessThanOrEqualTo(root.get("hireDate"), hiredBefore);
            else return null;
        };
    }
    public static Specification<Employee> istActive(Integer active){
        if (active != null) return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("active"), active));
        else return null;
    }
}
