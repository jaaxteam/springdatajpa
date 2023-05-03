package com.jaax.springdatajpa.repository;

import com.jaax.springdatajpa.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local,Long> {
}
