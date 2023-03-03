package com.tulius.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tulius.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
	
}
