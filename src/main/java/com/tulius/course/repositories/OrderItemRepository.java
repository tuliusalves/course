package com.tulius.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tulius.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
	
}
