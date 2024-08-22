package org.proway.student.excreq_param.service.specification;

import org.proway.student.excreq_param.model.Order;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class OrderSpecification {
    public static Specification<Order> byOrderNumber(Long orderNumber){
        return ((root, query, criteriaBuilder) -> orderNumber == null ? null : criteriaBuilder.equal(root.get("orderNumber"), orderNumber));
    }
    public static Specification<Order> byName(String customerName){
        return ((root, query, criteriaBuilder) -> customerName == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("costumerName")), "%" + customerName + "%"));

    }
    public static Specification<Order> byStatus(String status){
        return ((root, query, criteriaBuilder) -> status == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("status")), "%" + status + "%"));
    }
    public static Specification<Order> byPriceHange(Double minAmount, Double maxAmount) {
        return ((root, query, criteriaBuilder) -> {
            if (minAmount != null && maxAmount != null) return criteriaBuilder.between(root.get("totalAmount"), minAmount, maxAmount);
            else if (minAmount != null) return criteriaBuilder.greaterThanOrEqualTo(root.get("totalAmount"), minAmount);
            else if (maxAmount != null) return criteriaBuilder.lessThanOrEqualTo(root.get("totalAmount"), maxAmount);
            else return null;
        });
    }
    public static Specification<Order> hasDateRange(Date startDate, Date endDate) {
        return (root, query, criteriaBuilder) -> {
            if (startDate != null && endDate != null) return criteriaBuilder.between(root.get("orderDate"), startDate, endDate);
            else if (startDate != null) return criteriaBuilder.greaterThanOrEqualTo(root.get("orderDate"), startDate);
            else if (endDate != null) return criteriaBuilder.lessThanOrEqualTo(root.get("orderDate"), endDate);
            else return null;
        };
    }

}
