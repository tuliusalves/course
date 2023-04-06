package com.tulius.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tulius.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	
}
