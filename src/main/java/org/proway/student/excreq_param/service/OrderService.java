package org.proway.student.excreq_param.service;

import org.proway.student.excreq_param.model.Order;
import org.proway.student.excreq_param.repository.OrderRepository;
import org.proway.student.excreq_param.service.specification.OrderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> getOrders(Long orderNumber, String customerName, String status, Double minAmount, Double maxAmount, Date startDate, Date endDate){
        Specification<Order> spec = Specification
                .where(OrderSpecification.byOrderNumber(orderNumber))
                .and(OrderSpecification.byName(customerName))
                .and(OrderSpecification.byStatus(status))
                .and(OrderSpecification.byPriceHange(minAmount, maxAmount))
                .and(OrderSpecification.hasDateRange(startDate, endDate));

        return repository.findAll(spec);
    }
}
