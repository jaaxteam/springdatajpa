package com.jaax.springdatajpa.repository;

import com.jaax.springdatajpa.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    Page<Order> findByDescriptionContaining(String description, Pageable pageable);

}
