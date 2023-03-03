package com.tulius.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tulius.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
	
}
